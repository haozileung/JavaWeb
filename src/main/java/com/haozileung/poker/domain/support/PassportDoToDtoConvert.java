/**  
 * @Title: PassportDoToDtoConvert.java
 * @Package com.haozileung.poker.domain.support
 * @Description: Passport的领域对象到传输对象的转换类
 * @author haozi 
 * @date Aug 8, 2012 8:13:19 PM
 * @version V1.0  
 */
package com.haozileung.poker.domain.support;

import com.haozileung.poker.common.service.AbstractDoToDtoConvertor;
import com.haozileung.poker.common.service.DoToDtoConvertorFactory;
import com.haozileung.poker.domain.Passport;
import com.haozileung.poker.dto.PassportInfo;

/**
 * @ClassName: PassportDoToDtoConvert
 * @Description: Passport的领域对象到传输对象的转换类
 * @author haozi
 * @date Aug 8, 2012 8:13:19 PM
 * 
 */
public class PassportDoToDtoConvert extends
		AbstractDoToDtoConvertor<Passport, PassportInfo> {

	/**
	 * <p>
	 * Title: PassportDoToDtoConvert
	 * </p>
	 * <p>
	 * Description: 私有构造函数
	 * </p>
	 */
	private PassportDoToDtoConvert() {
	}
	
	/**
	 * @Fields instance : 私有静态实例，单例模式
	 */
	private static PassportDoToDtoConvert instance;
	
	static {
		instance = new PassportDoToDtoConvert();
		DoToDtoConvertorFactory.register(Passport.class, instance);
	}
	
	/**
	 * @Title: getInstance
	 * @Description: 单例模式，返回实例
	 * @param null
	 * @return PassportDoToDtoConvert    返回类型
	 * @throws
	 */
	public static PassportDoToDtoConvert getInstance(){
		return instance;
	}

	/**
	 * <p>
	 * Title: doToDto
	 * </p>
	 * <p>
	 * Description: 单个Passport对象转换
	 * </p>
	 * 
	 * @param obj
	 * @return passportInfo
	 * @see com.haozileung.poker.common.service.DoToDtoConvertor#doToDto(com.haozileung.poker.common.domain.DomainInterface)
	 */
	@Override
	public PassportInfo doToDto(Passport obj) {
		if (obj == null){
			return null;
		}
		PassportInfo passportInfo = new PassportInfo();
		passportInfo.setEmail(obj.getEmail());
		passportInfo.setLastLogin(obj.getLastLogin());
		passportInfo.setLoginIP(obj.getLoginIP());
		passportInfo.setPassportId(obj.getPassportId());
		passportInfo.setPassword(obj.getPassword());
		passportInfo.setUserName(obj.getUserName());
		return passportInfo;
	}
}
