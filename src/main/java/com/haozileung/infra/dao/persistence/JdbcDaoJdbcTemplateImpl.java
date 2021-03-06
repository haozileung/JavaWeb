package com.haozileung.infra.dao.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.infra.utils.NameUtil;

/**
 * jdbc操作dao
 */
public class JdbcDaoJdbcTemplateImpl implements JdbcDao {

	private static final Logger logger = LoggerFactory
			.getLogger(JdbcDaoJdbcTemplateImpl.class);
	/**
	 * spring readJdbcTemplate 对象
	 */
	protected JdbcOperations readJdbcTemplate;
	/**
	 * spring readJdbcTemplate 对象
	 */
	protected JdbcOperations writeJdbcTemplate;
	/**
	 * 名称处理器，为空按默认执行
	 */
	protected NameHandler nameHandler;

	/**
	 * 数据库方言
	 */
	protected String dialect;

	/**
	 * 插入数据
	 *
	 * @param entity
	 *            the entity
	 * @param criteria
	 *            the criteria
	 * @return long long
	 */
	private Long insert(Object entity, Criteria criteria) {
		Class<?> entityClass = SqlAssembleUtils
				.getEntityClass(entity, criteria);
		NameHandler handler = this.getNameHandler();
		String pkValue = handler.getPKValue(entityClass, this.dialect);
		if (StringUtils.isNotBlank(pkValue)) {
			String primaryName = handler.getPKName(entityClass);
			if (criteria == null) {
				criteria = Criteria.create(entityClass);
			}
			criteria.setPKValueName(NameUtil.getCamelName(primaryName), pkValue);
		}
		final BoundSql boundSql = SqlAssembleUtils.buildInsertSql(entity,
				criteria, this.getNameHandler());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		writeJdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(boundSql.getSql(),
						new String[] { boundSql.getPrimaryKey() });
				int index = 0;
				for (Object param : boundSql.getParams()) {
					index++;
					ps.setObject(index, param);
				}
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public Long insert(Object entity) {
		return this.insert(entity, null);
	}

	@Override
	public Long insert(Criteria criteria) {
		return this.insert(null, criteria);
	}

	@Override
	public void save(Object entity) {
		final BoundSql boundSql = SqlAssembleUtils.buildInsertSql(entity, null,
				this.getNameHandler());
		writeJdbcTemplate.update(boundSql.getSql(), boundSql.getParams()
				.toArray());
	}

	@Override
	public void save(Criteria criteria) {
		final BoundSql boundSql = SqlAssembleUtils.buildInsertSql(null,
				criteria, this.getNameHandler());
		writeJdbcTemplate.update(boundSql.getSql(), boundSql.getParams()
				.toArray());
	}

	@Override
	public void update(Criteria criteria) {
		BoundSql boundSql = SqlAssembleUtils.buildUpdateSql(null, criteria,
				this.getNameHandler());
		writeJdbcTemplate.update(boundSql.getSql(), boundSql.getParams()
				.toArray());
	}

	@Override
	public void update(Object entity) {
		BoundSql boundSql = SqlAssembleUtils.buildUpdateSql(entity, null,
				this.getNameHandler());
		writeJdbcTemplate.update(boundSql.getSql(), boundSql.getParams()
				.toArray());
	}

	@Override
	public void delete(Criteria criteria) {
		BoundSql boundSql = SqlAssembleUtils.buildDeleteSql(null, criteria,
				this.getNameHandler());
		writeJdbcTemplate.update(boundSql.getSql(), boundSql.getParams()
				.toArray());
	}

	@Override
	public void delete(Object entity) {
		BoundSql boundSql = SqlAssembleUtils.buildDeleteSql(entity, null,
				this.getNameHandler());
		writeJdbcTemplate.update(boundSql.getSql(), boundSql.getParams()
				.toArray());
	}

	@Override
	public void delete(Class<?> clazz, Long id) {
		BoundSql boundSql = SqlAssembleUtils.buildDeleteSql(clazz, id,
				this.getNameHandler());
		writeJdbcTemplate.update(boundSql.getSql(), boundSql.getParams()
				.toArray());
	}

	@Override
	public void deleteAll(Class<?> clazz) {
		String tableName = this.getNameHandler().getTableName(clazz);
		String sql = "TRUNCATE TABLE " + tableName;
		writeJdbcTemplate.execute(sql);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> queryList(Criteria criteria) {
		BoundSql boundSql = SqlAssembleUtils.buildListSql(null, criteria,
				this.getNameHandler());
		List<?> list = readJdbcTemplate.query(boundSql.getSql(), boundSql
				.getParams().toArray(), this.getRowMapper(criteria
				.getEntityClass()));
		return (List<T>) list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> queryList(T entity) {
		BoundSql boundSql = SqlAssembleUtils.buildListSql(entity, null,
				this.getNameHandler());
		List<?> list = readJdbcTemplate.query(boundSql.getSql(), boundSql
				.getParams().toArray(), this.getRowMapper(entity.getClass()));
		return (List<T>) list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> queryList(T entity, Criteria criteria) {
		BoundSql boundSql = SqlAssembleUtils.buildListSql(entity, criteria,
				this.getNameHandler());
		List<?> list = readJdbcTemplate.query(boundSql.getSql(), boundSql
				.getParams().toArray(), this.getRowMapper(entity.getClass()));
		return (List<T>) list;
	}

	@Override
	public int queryCount(Object entity, Criteria criteria) {
		BoundSql boundSql = SqlAssembleUtils.buildCountSql(entity, criteria,
				this.getNameHandler());
		return readJdbcTemplate.queryForObject(boundSql.getSql(), boundSql
				.getParams().toArray(), int.class);
	}

	@Override
	public int queryCount(Object entity) {
		BoundSql boundSql = SqlAssembleUtils.buildCountSql(entity, null,
				this.getNameHandler());
		return readJdbcTemplate.queryForObject(boundSql.getSql(), boundSql
				.getParams().toArray(), int.class);
	}

	@Override
	public int queryCount(Criteria criteria) {
		BoundSql boundSql = SqlAssembleUtils.buildCountSql(null, criteria,
				this.getNameHandler());
		return readJdbcTemplate.queryForObject(boundSql.getSql(), boundSql
				.getParams().toArray(), int.class);
	}

	@Override
	public <T> T get(Class<T> clazz, Long id) {
		BoundSql boundSql = SqlAssembleUtils.buildByIdSql(clazz, id, null,
				this.getNameHandler());
		// 采用list方式查询，当记录不存在时返回null而不会抛出异常
		List<T> list = readJdbcTemplate.query(boundSql.getSql(),
				this.getRowMapper(clazz), id);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.iterator().next();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T get(Criteria criteria, Long id) {
		BoundSql boundSql = SqlAssembleUtils.buildByIdSql(null, id, criteria,
				this.getNameHandler());

		// 采用list方式查询，当记录不存在时返回null而不会抛出异常
		List<T> list = (List<T>) readJdbcTemplate.query(boundSql.getSql(),
				this.getRowMapper(criteria.getEntityClass()), id);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.iterator().next();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T querySingleResult(T entity) {
		BoundSql boundSql = SqlAssembleUtils.buildQuerySql(entity, null,
				this.getNameHandler());

		// 采用list方式查询，当记录不存在时返回null而不会抛出异常
		List<?> list = readJdbcTemplate.query(boundSql.getSql(), boundSql
				.getParams().toArray(), this.getRowMapper(entity.getClass()));
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return (T) list.iterator().next();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T querySingleResult(Criteria criteria) {
		BoundSql boundSql = SqlAssembleUtils.buildQuerySql(null, criteria,
				this.getNameHandler());
		// 采用list方式查询，当记录不存在时返回null而不会抛出异常
		List<?> list = readJdbcTemplate.query(boundSql.getSql(), boundSql
				.getParams().toArray(), this.getRowMapper(criteria
				.getEntityClass()));
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return (T) list.iterator().next();
	}

	@Override
	public byte[] getBlobValue(Class<?> clazz, String fieldName, Long id) {
		String tableName = nameHandler.getTableName(clazz);
		String primaryName = nameHandler.getPKName(clazz);
		String columnName = nameHandler.getColumnName(clazz, fieldName);
		String tmp_sql = "select t.%s from %s t where t.%s = ?";
		String sql = String.format(tmp_sql, columnName, tableName, primaryName);
		return readJdbcTemplate.query(sql, new Object[] { id },
				new ResultSetExtractor<byte[]>() {
					@Override
					public byte[] extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						if (rs.next()) {
							return rs.getBytes(1);
						}
						return null;
					}
				});
	}

	public int updateForObject(final String sql, final Object[] args) {
		return writeJdbcTemplate.update(sql, args);
	}

	@SuppressWarnings("unchecked")
	public <T> T queryForObject(final String sql, final Object[] args,
			final Class<T> mappedClass) {
		// 采用list方式查询，当记录不存在时返回null而不会抛出异常
		List<?> list = readJdbcTemplate.query(sql, args,
				this.getRowMapper(mappedClass));
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return (T) list.iterator().next();
	}

	@SuppressWarnings("unchecked")
	public <T> T queryForSimpleObject(final String sql, final Object[] args,
			final Class<T> mappedClass) {

		List<?> list = readJdbcTemplate.queryForList(sql, args, mappedClass);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return (T) list.iterator().next();
	}

	public <T> List<T> queryForSimpleObjectList(String sql, Object[] args,
			final Class<T> mappedClass) {
		return readJdbcTemplate.queryForList(sql, args, mappedClass);
	}

	public Long addForObject(final String sql, final Object[] args) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		writeJdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql,
						Statement.RETURN_GENERATED_KEYS);
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	public <T> List<T> queryForObjectList(final String sql,
			final Object[] args, final Class<T> clazz) {
		List<T> list = Lists.newArrayList();
		list = readJdbcTemplate.query(sql, args, getRowMapper(clazz));
		return list;
	}

	@Override
	public <T> Pager pageSearch(final String sql, final String countSql,
			Pager pager, final Object[] args, final Class<T> clazz) {
		if (pager == null) {
			logger.error("Pager Cann't be NULL! ");
			return null;
		}
		List<T> data = queryForObjectList(sql, args, clazz);
		pager.setList(data);
		Long count = this.queryForSimpleObject(countSql, args, Long.class);
		pager.setItemsTotal(count);
		return pager;
	}

	/**
	 * 获取rowMapper对象
	 *
	 * @param clazz
	 * @return
	 */
	protected <T> RowMapper<T> getRowMapper(Class<T> clazz) {
		return BeanPropertyRowMapper.newInstance(clazz);
	}

	/**
	 * 获取名称处理器
	 *
	 * @return
	 */
	protected NameHandler getNameHandler() {

		if (this.nameHandler == null) {
			this.nameHandler = new DefaultNameHandler();
		}
		return this.nameHandler;
	}

	public void setNameHandler(NameHandler nameHandler) {
		this.nameHandler = nameHandler;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public void setReadJdbcTemplate(JdbcOperations readJdbcTemplate) {
		this.readJdbcTemplate = readJdbcTemplate;
	}

	public void setWriteJdbcTemplate(JdbcOperations writeJdbcTemplate) {
		this.writeJdbcTemplate = writeJdbcTemplate;
	}
}
