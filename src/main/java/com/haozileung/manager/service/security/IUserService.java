package com.haozileung.manager.service.security;

import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.manager.model.security.User;

/**
 * @author YamchaL
 *
 */
public interface IUserService {
	/**
	 * 
	 * @param username
	 * @param email
	 * @param pageNo
	 * @return
	 */
	Pager pageSearch(User user, Integer pageNo);

	/**
	 * 
	 * @param uid
	 * @return
	 */
	User getById(Long uid);

	/**
	 * @param user
	 * @return
	 */
	Long save(User user) throws Exception;

	/**
	 * @param user
	 */
	void update(User user) throws Exception ;

	/**
	 * @param uid
	 */
	void delete(Long uid);

	/**
	 * @param uid
	 */
	void ban(Long uid);
}
