package com.haozileung.jbloger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.jbloger.domain.Passport;
import com.haozileung.jbloger.dto.PassportInfo;
import com.haozileung.jbloger.rpst.PassportRepository;
import com.haozileung.jbloger.service.PassportService;

/**
 * @ClassName: PassportServiceImpl
 * @Description: Passport服务接口的实现类
 * @author haozi
 * @date Aug 7, 2012 1:01:08 PM
 *
 */
@Service("passportService")
//@Transactional//这是一种加事务的方式，还有一种是在spring配置文件中配置aop管理事务
public class PassportServiceImpl implements PassportService {
	
	@Autowired
	PassportRepository passportRepository;

	

	/**
	 * <p>Title: addPassport</p>
	 * <p>Description: </p>
	 * @param passport
	 * @see com.haozileung.jbloger.service.PassportService#addPassport(com.haozileung.jbloger.domain.Passport)
	 */
	public void addPassport(PassportInfo passport) {
		Passport pas = new Passport(passport);
		passportRepository.savePassport(pas);
	}


	/**
	 * <p>Title: deletePassport</p>
	 * <p>Description: </p>
	 * @param id
	 * @see com.haozileung.jbloger.service.PassportService#deletePassport(int)
	 */
	public void deletePassport(int id) {
		passportRepository.deletePassport(id);		
	}


	/**
	 * <p>Title: updatePassport</p>
	 * <p>Description: </p>
	 * @param passport
	 * @see com.haozileung.jbloger.service.PassportService#updatePassport(com.haozileung.jbloger.domain.Passport)
	 */
	public void updatePassport(PassportInfo passport) {
		Passport pas = new Passport(passport);
		passportRepository.updatePassport(pas);
	}

}
