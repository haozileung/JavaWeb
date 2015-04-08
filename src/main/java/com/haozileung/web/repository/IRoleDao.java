package com.haozileung.web.repository;

import java.util.List;
import java.util.Map;

import com.haozileung.web.model.security.Role;

public interface IRoleDao {
	public void add(Role u);

	public void delete(Role u);

	public void update(Role u);

	public List<Role> query(Map<String, Object> params);

	public Long count(Map<String, Object> params);

	public Role get(Long uid);
}
