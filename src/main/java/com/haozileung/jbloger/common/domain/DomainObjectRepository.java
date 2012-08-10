package com.haozileung.jbloger.common.domain;

import java.io.Serializable;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.criterion.Criterion;

import com.haozileung.jbloger.common.dto.DataTransferObject;

public interface DomainObjectRepository<O extends DomainInterface, D extends DataTransferObject> {
	/**
	 * 异常码：数据不存在
	 */
	public static final String OBJECT_NOT_FOUND = DomainObjectRepository.class
			.getName().concat(".001");

	/**
	 * 保存领域对象并返回其ID
	 * 
	 * @param object
	 */
	public Serializable save(O object);

	/**
	 * 更新领域对象
	 * 
	 * @param object
	 */
	public void update(O object);

	/**
	 * 删除领域对象
	 * 
	 * @param object
	 */
	public void delete(O object);

	/**
	 * 删除集合中的领域对象
	 * 
	 * @param objects
	 */
	public void deleteAll(List<O> objects);

	/**
	 * 根据标识获取领域对象，当领域对象不存在时，不能返回null，需要抛出ResObjectNotFoundException。
	 * 
	 * @param id
	 *            id
	 * @exception ObjectNotFoundException
	 */
	public O getById(Serializable id) throws ObjectNotFoundException;

	/**
	 * 方法用途和描述: 根据ID的集合获取匹配的集合对象
	 * 
	 * @param ids
	 * @return
	 * @throws ObjectNotFoundException
	 * @author 张宪新 新增日期：2009-7-29
	 * @since SAAS-RES version(1.0.0)
	 */
	public List<O> getByIds(List<Serializable> ids)
			throws ObjectNotFoundException;

	/**
	 * 根据ids删除持久化对象
	 * 
	 * @param id
	 * @exception ObjectNotFoundException
	 */
	public int deleteByIds(List<Serializable> ids);

	/**
	 * 查询
	 * 
	 * @param searchCriteria
	 * @param searchManner
	 * @param searchOrder
	 */
	public List<O> search(List<Criterion> crits);

//	/**
//	 * 分页查询
//	 * 
//	 * @param searchCriteria
//	 * @param searchManner
//	 * @param searchOrder
//	 * @param pageNo
//	 * @param pageSize
//	 */
//	public Page<D> pagedSearch(C searchCriteria, int pageNo, int pageSize);

	/**
	 * 统计指定实体的记录数
	 * 
	 * @return
	 */
	public long count();

}
