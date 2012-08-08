/**  
 * @Title: PassportDoToDtoConvert.java
 * @Package com.haozileung.jbloger.domain.support
 * @Description: Passport的领域对象到传输对象的转换类
 * @author haozi 
 * @date Aug 8, 2012 8:13:19 PM
 * @version V1.0  
 */
package com.haozileung.jbloger.domain.support;

import java.util.ArrayList;
import java.util.List;

import com.haozileung.jbloger.common.service.AbstractDoToDtoConvertor;
import com.haozileung.jbloger.common.service.DoToDtoConvertorFactory;
import com.haozileung.jbloger.domain.Passport;
import com.haozileung.jbloger.dto.PassportInfo;

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
	 * @see com.haozileung.jbloger.common.service.DoToDtoConvertor#doToDto(com.haozileung.jbloger.common.domain.DomainInterface)
	 */
	@Override
	public PassportInfo doToDto(Passport obj) {
		PassportInfo passportInfo = new PassportInfo();
		passportInfo.setEmail(obj.getEmail());
		passportInfo.setLastLogin(obj.getLastLogin());
		passportInfo.setLoginIP(obj.getLoginIP());
		passportInfo.setPassportId(obj.getPassportId());
		passportInfo.setPassword(obj.getPassword());
		passportInfo.setUserName(obj.getUserName());
		return passportInfo;
	}
	
	/**
	 * @Title: dosToDtos
	 * @Description: 多个Passport对象的转换
	 * @param 多个Passport对象
	 * @return List<PassportInfo>    返回类型
	 * @throws
	 */
	public List<PassportInfo> dosToDtos(List<Passport> objs){
		List<PassportInfo> passportInfos = new ArrayList<PassportInfo>();
		for (Passport p : objs){
			passportInfos.add(doToDto(p));
		}
		return passportInfos;
	}
}
