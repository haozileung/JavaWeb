/**
 * 
 */
package com.haozileung.poker.common.service;

import java.util.List;

import com.haozileung.poker.common.domain.DomainInterface;
import com.haozileung.poker.common.dto.DataTransferObject;


/**
 * DO到DTO转换器
 */
public interface DoToDtoConvertor<O extends DomainInterface, D extends DataTransferObject> {
	
	public D doToDto(O obj);
	
	public List<D> dos2Dtos(List<O> os);
	
	public D doToDtoWithLazy(O obj);
	
	public List<D> dos2DtosWithLazy(List<O> os);
	
}
