package com.haozileung.manager.service.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haozileung.infra.dao.interceptor.PageControl;
import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.security.Resource;
import com.haozileung.manager.model.security.RoleResource;
import com.haozileung.manager.service.security.IResourceService;

/**
 * @author YamchaL
 *
 */
@Service
@Transactional
public class ResourceServiceImpl implements IResourceService {

	@Autowired
	private JdbcDao dao;

	@Override
	public Pager pageSearch(Resource resource, Integer pageNo) {
		PageControl.performPage(pageNo, 15);
		dao.queryList(resource);
		Pager pager = PageControl.getPager();
		return pager;
	}

	@Override
	public Resource getById(Long id) {
		return dao.get(Resource.class, id);
	}

	@Override
	public Long save(Resource resource) throws Exception {
		Resource r = dao.querySingleResult(Criteria.create(Resource.class)
				.where("code", new Object[] { resource.getCode() })
				.and("name", new Object[] { resource.getName() }));
		if (r != null) {
			throw new Exception("资源已存在");
		}
		return dao.insert(resource);
	}

	@Override
	public void update(Resource resource) throws Exception {
		if (resource.getId() == null) {
			new Exception("ID不能为空");
		}
		Resource r = dao.querySingleResult(Criteria.create(Resource.class)
				.where("code", new Object[] { resource.getCode() })
				.and("name", new Object[] { resource.getName() }));
		if (r != null && !r.getId().equals(resource.getId())) {
			throw new Exception("角色已存在");
		}
		dao.update(resource);
	}

	@Override
	public void delete(Long id) {
		if (id != null) {
			Resource r = new Resource();
			r.setId(id);
			dao.delete(r);
			RoleResource rr = new RoleResource();
			rr.setResourceId(id);
			dao.delete(rr);
		}
	}

	@Override
	public void ban(Long id) {
		if (id != null) {
			Resource resource = dao.get(Resource.class, id);
			if (resource.getStatus() != null && resource.getStatus().equals(0)) {
				resource.setStatus(1);
			} else {
				resource.setStatus(0);
			}
			dao.update(resource);
		}
	}

	@Override
	public List<Resource> getResourceGroups() {
		return dao.queryList(Criteria.create(Resource.class).where("groupId",
				new Object[] { 0 }));
	}

}
