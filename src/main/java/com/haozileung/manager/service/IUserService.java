package com.haozileung.manager.service;

import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.manager.model.security.User;

public interface IUserService {
	/**
	 * 
	 * @param username
	 * @param email
	 * @param pageNo
	 * @return
	 */
	Pager pageSearch(String username, String email, Integer pageNo);

	/**
	 * 
	 * @param uid
	 * @return
	 */
	User getById(Long uid);
}
