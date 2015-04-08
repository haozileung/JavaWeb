package com.haozileung.web.repository;

import java.util.List;
import java.util.Map;

import com.haozileung.web.model.security.Permission;

public interface IPermissionDao {
	public void add(Permission u);

	public void delete(Permission u);

	public void update(Permission u);

	public List<Permission> query(Map<String, Object> params, Long start,
			Integer limit);

	public Long count(Map<String, Object> params);

	public Permission get(Long uid);
}
