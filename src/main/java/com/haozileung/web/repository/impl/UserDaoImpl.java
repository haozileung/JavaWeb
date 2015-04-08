package com.haozileung.web.repository.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

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
		getJdbcTemplate().update("", new Object[] {});
	}

	@Override
	public void delete(User u) {
		getJdbcTemplate().update("", new Object[] {});
	}

	@Override
	public void update(User u) {
		getJdbcTemplate().update("", new Object[] {});
	}

	@Override
	public List<User> query(Map<String, Object> params) {
		return getJdbcTemplate().queryForList("", new Object[] {}, User.class);
	}

	@Override
	public Long count(Map<String, Object> params) {
		return getJdbcTemplate()
				.queryForObject("", new Object[] {}, Long.class);
	}

	@Override
	public User get(Long uid) {
		return getJdbcTemplate().queryForObject("", new Object[] { uid },
				User.class);
	}
}
