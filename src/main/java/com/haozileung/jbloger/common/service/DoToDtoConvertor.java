/**
 * 
 */
package com.haozileung.jbloger.common.service;

import java.util.List;

import com.haozileung.jbloger.common.domain.DomainInterface;
import com.haozileung.jbloger.common.dto.DataTransferObject;


/**
 * DO到DTO转换器
 */
public interface DoToDtoConvertor<O extends DomainInterface, D extends DataTransferObject> {
	
	public D doToDto(O obj);
	
	public List<D> dos2Dtos(List<O> os);
	
	public D doToDtoWithLazy(O obj);
	
	public List<D> dos2DtosWithLazy(List<O> os);
	
}
