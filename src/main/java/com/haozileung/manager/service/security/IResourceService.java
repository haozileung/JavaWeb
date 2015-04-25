package com.haozileung.manager.service.security;

import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.manager.model.security.Resource;

/**
 * @author YamchaL
 *
 */
public interface IResourceService {
	/**
	 * 
	 * @param resource
	 * @param pageNo
	 * @return
	 */
	Pager pageSearch(Resource resource, Integer pageNo);

	/**
	 * 
	 * @param id
	 * @return
	 */
	Resource getById(Long id);

	/**
	 * @param resource
	 * @return
	 */
	Long save(Resource resource) throws Exception;

	/**
	 * @param resource
	 */
	void update(Resource resource) throws Exception;

	/**
	 * @param id
	 */
	void delete(Long id);

	/**
	 * @param id
	 */
	void ban(Long id);
}
