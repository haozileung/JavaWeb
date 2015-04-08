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
	public void add(Role u) {
		getJdbcTemplate().update("", new Object[] {});
	}

	@Override
	public void delete(Role u) {
		getJdbcTemplate().update("", new Object[] {});
	}

	@Override
	public void update(Role u) {
		getJdbcTemplate().update("", new Object[] {});

	}

	@Override
	public List<Role> query(Map<String, Object> params) {
		return getJdbcTemplate().queryForList("", new Object[] {}, Role.class);
	}

	@Override
	public Long count(Map<String, Object> params) {
		return getJdbcTemplate()
				.queryForObject("", new Object[] {}, Long.class);
	}

	@Override
	public Role get(Long uid) {
		return getJdbcTemplate().queryForObject("", new Object[] { uid },
				Role.class);
	}
}
