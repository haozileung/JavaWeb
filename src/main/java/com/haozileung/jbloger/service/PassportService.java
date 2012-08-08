package com.haozileung.jbloger.service;

import com.haozileung.jbloger.common.service.Service;
import com.haozileung.jbloger.dto.PassportInfo;

/**
 * @ClassName: PassportService
 * @Description: Passport的服务层接口
 * @author haozi
 * @date Aug 7, 2012 12:55:05 PM
 *
 */
public interface PassportService extends Service{
	
	/**
	 * @Title: addPassport
	 * @Description: 添加一个Passport
	 * @param 参数
	 * @return void    返回类型
	 * @throws
	 */
	public void addPassport(PassportInfo passport);
	

	/**
	 * @Title: deletePassport
	 * @Description: 删除一个Passport
	 * @param 参数
	 * @return void    返回类型
	 * @throws
	 */
	public void deletePassport(int id);
	

	/**
	 * @Title: updatePassport
	 * @Description: 更新一个Passport
	 * @param 参数
	 * @return void    返回类型
	 * @throws
	 */
	public void updatePassport(PassportInfo passport);

}
