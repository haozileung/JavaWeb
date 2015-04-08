package com.haozileung.web.repository.security;

import java.util.Map;

import com.haozileung.web.dto.Page;
import com.haozileung.web.model.security.Role;

public interface IRoleDao {
	public void add(Role r);

	public void delete(Role r);

	public void update(Role r);

	public Page<Role> query(Map<String, Object> params, Page<Role> page);

	public Role get(Long rid);
}
