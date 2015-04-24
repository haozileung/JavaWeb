package com.haozileung.manager.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haozileung.infra.dao.interceptor.PageControl;
import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.security.User;
import com.haozileung.manager.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory
			.getLogger(IUserService.class);

	@Autowired
	private JdbcDao dao;

	@Override
	public Pager pageSearch(String username, String email, Integer pageNo) {
		PageControl.performPage(pageNo, 10);
		User u = new User();
		u.setEmail(email);
		u.setName(username);
		dao.queryList(u, Criteria.create(User.class).asc("id"));
		Pager pager = PageControl.getPager();
		return pager;
	}

	public User getById(Long uid) {
		return dao.get(User.class, uid);
	}

}
