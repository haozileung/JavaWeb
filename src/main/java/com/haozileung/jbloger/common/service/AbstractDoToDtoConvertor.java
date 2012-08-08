package com.haozileung.jbloger.common.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haozileung.jbloger.common.domain.DomainInterface;
import com.haozileung.jbloger.common.dto.DataTransferObject;



/**
 * 接口或类的说明: 抽象的DO转DTO转换器
 */
public abstract class AbstractDoToDtoConvertor<O extends DomainInterface, D extends DataTransferObject> implements DoToDtoConvertor<O, D> {

	protected Log logger = LogFactory.getLog(getClass());

	protected AbstractDoToDtoConvertor() {
		super();
	}

	public D doToDtoWithLazy(O obj) {
		return this.doToDto(obj);
	}

	public List<D> dos2DtosWithLazy(List<O> os) {
		if(os==null || os.isEmpty()){
			return new ArrayList<D>();
		}
		List<D> answerInfos = new ArrayList<D>(os.size());
		for(O o: os){
			answerInfos.add(doToDtoWithLazy(o));
		}
		return answerInfos;
	}
	
	public List<D> dos2Dtos(List<O> os) {
		if(os==null || os.isEmpty()){
			return new ArrayList<D>();
		}
		List<D> answerInfos = new ArrayList<D>(os.size());
		for(O o: os){
			answerInfos.add(doToDto(o));
		}
		return answerInfos;
	}
	
}
