package com.haozileung.web.repository.security;

import java.util.Map;

import com.haozileung.web.dto.Page;
import com.haozileung.web.model.security.Permission;

public interface IPermissionDao {
	public void add(Permission u);

	public void delete(Permission u);

	public void update(Permission u);

	public Page<Permission> query(Map<String, Object> params,
			Page<Permission> page);

	public Permission get(Long uid);
}
