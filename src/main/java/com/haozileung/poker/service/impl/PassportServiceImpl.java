package com.haozileung.poker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.poker.common.util.HashUtil;
import com.haozileung.poker.domain.Passport;
import com.haozileung.poker.domain.support.PassportDoToDtoConvert;
import com.haozileung.poker.dto.PassportInfo;
import com.haozileung.poker.rpst.PassportRepository;
import com.haozileung.poker.service.PassportService;

/**
 * @ClassName: PassportServiceImpl
 * @Description: Passport服务接口的实现类
 * @author haozi
 * @date Aug 7, 2012 1:01:08 PM
 * 
 */
@Service("passportService")
// @Transactional//这是一种加事务的方式，还有一种是在spring配置文件中配置aop管理事务
public class PassportServiceImpl implements PassportService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	PassportRepository passportRepository;

	/**
	 * <p>
	 * Title: addPassport
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param passport
	 * @see com.haozileung.poker.service.PassportService#addPassport(com.haozileung.poker.domain.Passport)
	 */
	public void addPassport(PassportInfo passport) {
		Passport pas = new Passport(passport);
		passportRepository.save(pas);
	}

	/**
	 * <p>
	 * Title: deletePassport
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param id
	 * @see com.haozileung.poker.service.PassportService#deletePassport(int)
	 */
	public void deletePassport(int id) {
		Passport p = passportRepository.getById(id);
		if (p != null) {
			passportRepository.delete(p);
		}
	}

	/**
	 * <p>
	 * Title: updatePassport
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param passport
	 * @see com.haozileung.poker.service.PassportService#updatePassport(com.haozileung.poker.domain.Passport)
	 */
	public void updatePassport(PassportInfo passport) {
		Passport pas = new Passport(passport);
		passportRepository.update(pas);
	}

	@Override
	public PassportInfo validatePassport(PassportInfo passport) {
		Passport p = new Passport(passport);
		List<Criterion> crt = new ArrayList<Criterion>();
		Criterion c = Restrictions.eq("userName", p.getUserName());
		crt.add(c);
		List<Passport> passports = passportRepository.search(crt);
		if (passports != null && passports.size() > 0) {
			Passport p2 = passports.get(0);
			if (HashUtil.hashValidate(p.getPassword(), p2.getPassword())) {
				p2.setPassword(HashUtil.doHash(p.getPassword()));
				p2.setLastLogin(p.getLastLogin());
				p2.setLoginIP(p.getLoginIP());
				try{
				passportRepository.update(p2);
				}catch (HibernateException he){
					logger.error(he.getMessage());
				}
				logger.info(p2.getUserName()+" "+p2.getPassportId());
				return PassportDoToDtoConvert.getInstance().doToDto(p2);
			}
		}
		return null;
	}

	@Override
	public PassportInfo findPassportById(int id) {
		Passport p = null;
		try {
			p = passportRepository.getById(id);
		} catch (ObjectNotFoundException onf) {
			return null;
		}
		return PassportDoToDtoConvert.getInstance().doToDto(p);
	}

	@Override
	public PassportInfo findPassportByUserName(String username) {
		List<Criterion> crt = new ArrayList<Criterion>();
		Criterion c = Restrictions.eq("userName", username);
		crt.add(c);
		List<PassportInfo> passportInfos = PassportDoToDtoConvert.getInstance()
				.dos2Dtos(passportRepository.search(crt));
		if (passportInfos != null && passportInfos.size() > 0) {
			return passportInfos.get(0);
		}
		return null;
	}

}
