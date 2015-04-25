package com.haozileung.manager.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;
import com.haozileung.infra.dao.interceptor.PageControl;
import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.security.User;
import com.haozileung.manager.model.security.UserRole;
import com.haozileung.manager.service.security.IUserService;

/**
 * @author YamchaL
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private JdbcDao dao;

	@Override
	public Pager pageSearch(User user, Integer pageNo) {
		PageControl.performPage(pageNo, 15);
		dao.queryList(user);
		Pager pager = PageControl.getPager();
		return pager;
	}

	public User getById(Long uid) {
		return dao.get(User.class, uid);
	}

	@Override
	public Long save(User user) throws Exception {
		if (!Strings.isNullOrEmpty(user.getPassword())) {
			String hashed = Hashing.sha512()
					.hashString(user.getPassword(), Charsets.UTF_8).toString();
			user.setPassword(hashed);
		}
		User u = dao.querySingleResult(Criteria.create(User.class).where(
				"email", new Object[] { user.getEmail() }));
		if (u != null) {
			throw new Exception("帐户已存在");
		}
		return dao.insert(user);
	}

	@Override
	public void update(User user) throws Exception {
		if (user.getId() == null) {
			return;
		}
		if (!Strings.isNullOrEmpty(user.getPassword())) {
			String hashed = Hashing.sha512()
					.hashString(user.getPassword(), Charsets.UTF_8).toString();
			user.setPassword(hashed);
		}
		User u = dao.querySingleResult(Criteria.create(User.class).where(
				"email", new Object[] { user.getEmail() }));
		if (u != null && !user.getId().equals(u.getId())) {
			throw new Exception("帐户已存在");
		}
		dao.update(user);
	}

	@Override
	public void delete(Long uid) {
		if (uid != null) {
			User u = new User();
			u.setId(uid);
			dao.delete(u);
			UserRole ur = new UserRole();
			ur.setUserId(uid);
			dao.delete(ur);
		}
	}

	@Override
	public void ban(Long uid) {
		if (uid != null) {
			User user = dao.get(User.class, uid);
			if (user.getStatus() != null && user.getStatus().equals(0)) {
				user.setStatus(1);
			} else {
				user.setStatus(0);
			}
			dao.update(user);
		}
	}

}
