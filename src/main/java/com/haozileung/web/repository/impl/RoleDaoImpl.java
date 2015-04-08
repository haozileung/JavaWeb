package com.haozileung.web.repository.impl;

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
import com.haozileung.web.model.security.Role;
import com.haozileung.web.repository.IRoleDao;

@Repository
public class RoleDaoImpl extends JdbcDaoSupport implements IRoleDao {
	private static final Logger logger = LoggerFactory
			.getLogger(IRoleDao.class);

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void add(Role r) {
		logger.debug("添加角色 - name:{},status{}", r.getName(), r.getStatus());
		getJdbcTemplate().update(
				"insert into t_role (name, status) values( ?, ?)",
				new Object[] { r.getName(), r.getStatus() });
	}

	@Override
	public void delete(Role r) {
		logger.debug("删除角色 - id:{},name:{},status{}", r.getId(), r.getName(),
				r.getStatus());
		getJdbcTemplate().update("delete from t_role where id = ?",
				new Object[] { r.getId() });
	}

	@Override
	public void update(Role r) {
		logger.debug("更新角色 - id:{},name:{},status{}", r.getId(), r.getName(),
				r.getStatus());
		getJdbcTemplate().update(
				"update t_role set name = ?, status = ? where id = ?",
				new Object[] { r.getName(), r.getStatus(), r.getId() });

	}

	@Override
	public List<Role> query(Map<String, Object> params, Long start,
			Integer limit) {
		StringBuffer sb = new StringBuffer("SELECT * FROM t_role");
		List<String> where = Lists.newArrayList();
		List<Object> args = Lists.newArrayList();
		Set<String> keys = params.keySet();
		for (String key : keys) {
			if (!Strings.isNullOrEmpty(key)) {
				where.add(" `" + key + "` = ? ");
				args.add(params.get(key));
			}
		}
		if (where.size() > 0) {
			sb.append(" WHERE ").append(Joiner.on("AND").join(where));
		}
		if (start != null && limit != null && start >= 0 && limit > 0) {
			sb.append(" LIMIT ").append(start).append(",").append(limit);
		}
		return getJdbcTemplate().queryForList(sb.toString(), args.toArray(),
				Role.class);
	}

	@Override
	public Long count(Map<String, Object> params) {
		StringBuffer sb = new StringBuffer("SELECT COUNT(*) FROM t_role");
		List<String> where = Lists.newArrayList();
		List<Object> args = Lists.newArrayList();
		Set<String> keys = params.keySet();
		for (String key : keys) {
			if (!Strings.isNullOrEmpty(key)) {
				where.add(" `" + key + "` = ? ");
				args.add(params.get(key));
			}
		}
		if (where.size() > 0) {
			sb.append(" WHERE ").append(Joiner.on("AND").join(where));
		}
		return getJdbcTemplate().queryForObject(sb.toString(), args.toArray(),
				Long.class);
	}

	@Override
	public Role get(Long rid) {
		return getJdbcTemplate().queryForObject(
				"SELECT * FROM t_role WHERE id = ?", new Object[] { rid },
				Role.class);
	}
}
