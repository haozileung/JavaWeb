package com.haozileung.web.repository;

import java.util.List;
import java.util.Map;

import com.haozileung.web.model.security.User;

public interface IUserDao {
	public void add(User u);

	public void delete(User u);

	public void update(User u);

	public List<User> query(Map<String, Object> params);

	public Long count(Map<String, Object> params);

	public User get(Long uid);
}
