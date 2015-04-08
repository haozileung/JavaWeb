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
import com.haozileung.web.model.security.User;
import com.haozileung.web.repository.IUserDao;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {
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
	public void add(User u) {
		logger.debug("添加用户 - name:{},email:{},password:{},status{}",
				u.getName(), u.getStatus());
		getJdbcTemplate()
				.update("insert into t_user (name, email, password, status) values( ?, ?, ?, ?)",
						new Object[] { u.getName(), u.getEmail(),
								u.getPassword(), u.getStatus() });
	}

	@Override
	public void delete(User u) {
		logger.debug("删除角色 - id:{},name:{},email:{},password:{},status{}",
				u.getId(), u.getName(), u.getEmail(), u.getPassword(),
				u.getStatus());
		getJdbcTemplate().update("delete from t_user where id = ?",
				new Object[] { u.getId() });
	}

	@Override
	public void update(User u) {
		logger.debug("更新角色 - id:{},name:{},email:{},password:{},status{}",
				u.getId(), u.getName(), u.getEmail(), u.getPassword(),
				u.getStatus());
		getJdbcTemplate().update(
				"update t_user set name = ?, email = ?, password = ?, status = ? where id = ?",
				new Object[] { u.getName(), u.getEmail(), u.getPassword(),
						u.getStatus(), u.getId() });

	}

	@Override
	public List<User> query(Map<String, Object> params, Long start,
			Integer limit) {
		StringBuffer sb = new StringBuffer("SELECT * FROM t_user");
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
				User.class);
	}

	@Override
	public Long count(Map<String, Object> params) {
		StringBuffer sb = new StringBuffer("SELECT COUNT(*) FROM t_user");
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
	public User get(Long uid) {
		return getJdbcTemplate().queryForObject(
				"SELECT * FROM t_user WHERE id = ?", new Object[] { uid },
				User.class);
	}
}
