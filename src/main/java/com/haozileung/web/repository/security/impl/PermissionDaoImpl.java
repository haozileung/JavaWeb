package com.haozileung.web.repository.security.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.haozileung.web.dto.Page;
import com.haozileung.web.model.security.Permission;
import com.haozileung.web.repository.security.IPermissionDao;
import com.haozileung.web.repository.security.IUserDao;

@Repository
public class PermissionDaoImpl extends JdbcDaoSupport implements IPermissionDao {
	private static final Logger logger = LoggerFactory
			.getLogger(IUserDao.class);

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void add(Permission p) {
		logger.debug("添加权限 - type:{},value:{},status{}", p.getType(),
				p.getValue(), p.getStatus());
		getJdbcTemplate()
				.update("insert into t_permission (type, value, status) values (?, ?, ?)",
						new Object[] { p.getType(), p.getValue(), p.getStatus() });
	}

	@Override
	public void delete(Permission p) {
		logger.debug("删除权限 -id:{},type:{},value:{},status{}", p.getId(),
				p.getType(), p.getValue(), p.getStatus());
		getJdbcTemplate().update("delete from t_permission where id = ?",
				new Object[] { p.getId() });
	}

	@Override
	public void update(Permission p) {
		logger.debug("更新权限 -id:{},type:{},value:{},status{}", p.getId(),
				p.getType(), p.getValue(), p.getStatus());
		getJdbcTemplate()
				.update("update t_permission set type = ?, value = ?, status = ? where id = ?",
						new Object[] { p.getType(), p.getValue(),
								p.getStatus(), p.getId() });

	}

	@Override
	public Page<Permission> query(Map<String, Object> params,
			Page<Permission> page) {
		StringBuffer count = new StringBuffer(
				"SELECT COUNT(*) FROM t_permission");
		StringBuffer list = new StringBuffer("SELECT * FROM t_permission");
		StringBuffer where = new StringBuffer();
		List<String> condition = Lists.newArrayList();
		List<Object> args = Lists.newArrayList();
		Set<String> keys = params.keySet();
		for (String key : keys) {
			if (!Strings.isNullOrEmpty(key)) {
				condition.add(" `" + key + "` = ? ");
				args.add(params.get(key));
			}
		}
		if (condition.size() > 0) {
			where.append(" WHERE ").append(Joiner.on("AND").join(condition));
		}
		count.append(where);
		if (!Strings.isNullOrEmpty(page.getOrderBy())
				&& !Strings.isNullOrEmpty(page.getOrder())) {
			list.append(where).append(" ORDER BY ").append(page.getOrderBy())
					.append(" ").append(page.getOrder());
		}
		list.append(" LIMIT ").append(page.getFirst())
				.append(page.getPageSize());
		page.setTotalCount(getJdbcTemplate().queryForObject(count.toString(),
				args.toArray(), Long.class));
		page.setResult(getJdbcTemplate().queryForList(list.toString(),
				args.toArray(), Permission.class));
		return page;
	}

	@Override
	public Permission get(Long pid) {
		return getJdbcTemplate().queryForObject(
				"SELECT * FROM t_permission WHERE id = ?",
				new Object[] { pid }, Permission.class);
	}
}
