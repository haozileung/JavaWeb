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
import com.haozileung.web.model.security.Permission;
import com.haozileung.web.repository.IPermissionDao;
import com.haozileung.web.repository.IUserDao;

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
	public List<Permission> query(Map<String, Object> params, Long start,
			Integer limit) {
		StringBuffer sb = new StringBuffer("SELECT * FROM t_permission");
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
				Permission.class);
	}

	@Override
	public Long count(Map<String, Object> params) {
		StringBuffer sb = new StringBuffer("SELECT COUNT(*) FROM t_permission");
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
	public Permission get(Long pid) {
		return getJdbcTemplate().queryForObject(
				"SELECT * FROM t_permission WHERE id = ?",
				new Object[] { pid }, Permission.class);
	}
}
