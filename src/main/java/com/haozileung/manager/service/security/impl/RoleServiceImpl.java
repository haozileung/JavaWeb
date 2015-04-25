package com.haozileung.manager.service.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haozileung.infra.dao.interceptor.PageControl;
import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.security.Role;
import com.haozileung.manager.model.security.RoleResource;
import com.haozileung.manager.model.security.UserRole;
import com.haozileung.manager.service.security.IRoleService;

/**
 * @author YamchaL
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private JdbcDao dao;

	@Override
	public Pager pageSearch(Role role, Integer pageNo) {
		PageControl.performPage(pageNo, 15);
		dao.queryList(role);
		Pager pager = PageControl.getPager();
		return pager;
	}

	public Role getById(Long id) {
		return dao.get(Role.class, id);
	}

	@Override
	public Long save(Role role) throws Exception {
		Role u = dao.querySingleResult(Criteria.create(Role.class).where(
				"name", new Object[] { role.getName() }));
		if (u != null) {
			throw new Exception("角色已存在");
		}
		return dao.insert(role);
	}

	@Override
	public void update(Role role) throws Exception {
		if (role.getId() == null) {
			new Exception("ID不能为空");
		}
		Role r = dao.querySingleResult(Criteria.create(Role.class).where(
				"name", new Object[] { role.getName() }));
		if (r != null && !r.getId().equals(role.getId())) {
			throw new Exception("角色已存在");
		}
		dao.update(role);
	}

	@Override
	public void delete(Long id) {
		if (id != null) {
			Role r = new Role();
			r.setId(id);
			dao.delete(r);
			UserRole ur = new UserRole();
			ur.setRoleId(id);
			dao.delete(ur);
			RoleResource rr = new RoleResource();
			rr.setRoleId(id);
			dao.delete(rr);
		}
	}

	@Override
	public void ban(Long id) {
		if (id != null) {
			Role role = dao.get(Role.class, id);
			if (role.getStatus() != null && role.getStatus().equals(0)) {
				role.setStatus(1);
			} else {
				role.setStatus(0);
			}
			dao.update(role);
		}
	}

}
