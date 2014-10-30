/**
 * 
 */
package com.haozileung.poker.common.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haozileung.poker.common.domain.DomainInterface;
import com.haozileung.poker.common.dto.DataTransferObject;
import com.haozileung.poker.common.exception.BaseUncheckedException;



/**
 * DoToDtoConvertor工厂
 */
@SuppressWarnings("unchecked" )
public class DoToDtoConvertorFactory {
	protected final static Log logger = LogFactory.getLog(DoToDtoConvertorFactory.class);
	
	@SuppressWarnings("rawtypes")
	private static Map map = new HashMap();
	private Set<String> convertorClassNames = new HashSet<String>();
	
	public static void register(Class<? extends DomainInterface> domainObjectClass, DoToDtoConvertor<? extends DomainInterface, ? extends DataTransferObject> convertor) {
		if(logger.isInfoEnabled())
			logger.info("注册转换器：【name="+domainObjectClass + ";convertorClassName=" + convertor.getClass().getName() + "】");
		map.put(domainObjectClass, convertor);
	}

	@SuppressWarnings("rawtypes")
	public static DoToDtoConvertor getConvertor(Class<? extends DomainInterface> domainObjectClass) {
		if(map.get(domainObjectClass)==null){
			throw new BaseUncheckedException(DoToDtoConvertorFactory.class.getName().concat("unregisterDoToDtoConvertor"), 
					"名称为\""+domainObjectClass+"\"的转换器未注册，请先注册后再使用! ");
		}
		return (DoToDtoConvertor)map.get(domainObjectClass);
	}

	public void setConvertorClassNames(Set<String> convertorClassNames) {
		this.convertorClassNames = convertorClassNames;
	}

	public void init() throws ClassNotFoundException {
		for(String convertorClassName : convertorClassNames) {
			Class.forName(convertorClassName);
		}
		convertorClassNames.clear();
	}
	
}
