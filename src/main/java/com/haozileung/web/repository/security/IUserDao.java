package com.haozileung.web.repository.security;

import java.util.Map;

import com.haozileung.web.dto.Page;
import com.haozileung.web.model.security.User;

public interface IUserDao {
	public void add(User u);

	public void delete(User u);

	public void update(User u);

	public Page<User> query(Map<String, Object> params, Page<User> page);

	public User get(Long uid);
}
