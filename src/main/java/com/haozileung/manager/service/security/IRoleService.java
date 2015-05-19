package com.haozileung.manager.service.security;

import java.util.List;

import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.manager.model.security.Role;

/**
 * @author YamchaL
 *
 */
public interface IRoleService {

	/**
	 * 
	 * @param email
	 * @return
	 */
	List<Role> findRoleByUserEmail(String email);

	/**
	 * 
	 * @param rolename
	 * @param email
	 * @param pageNo
	 * @return
	 */
	Pager pageSearch(Role role, Integer pageNo);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Role getById(Long id);

	/**
	 * @param role
	 * @return
	 */
	Long save(Role role) throws Exception;

	/**
	 * @param role
	 */
	void update(Role role) throws Exception;

	/**
	 * @param id
	 */
	void delete(Long id);

	/**
	 * @param id
	 */
	void ban(Long id);
}
