package com.haozileung.web.repository;

import java.util.List;
import java.util.Map;

import com.haozileung.web.model.security.Role;

public interface IRoleDao {
	public void add(Role r);

	public void delete(Role r);

	public void update(Role r);

	public List<Role> query(Map<String, Object> params, Long start,
			Integer limit);

	public Long count(Map<String, Object> params);

	public Role get(Long rid);
}
