package com.haozileung.jbloger.common.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.jbloger.common.dto.DataTransferObject;
import com.haozileung.jbloger.common.exception.BaseCheckedException;
import com.haozileung.jbloger.common.service.DoToDtoConvertor;
import com.haozileung.jbloger.common.service.DoToDtoConvertorFactory;

public abstract class AbstractDomainRepository<O extends DomainInterface, D extends DataTransferObject>
		implements DomainObjectRepository<O, D> {

	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * 获取领域对象的类
	 * 
	 * @return
	 */
	protected abstract Class<O> getDomainObjectClass();

	/**
	 * 获取领域对象的类名
	 * 
	 * @return
	 */
	protected String getDomainObjectClassName() {
		return getDomainObjectClass().getName();
	}

	/**
	 * do和dto之间的转换方法
	 * 
	 * @param os
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<D> dos2Dtos(List<O> os) {
		DoToDtoConvertor<O, D> do2dtoConvertor = DoToDtoConvertorFactory
				.getConvertor(getDomainObjectClass());
		return do2dtoConvertor.dos2Dtos(os);
	}

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public Serializable save(O object) {
		return sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void update(O object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(O object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public void deleteAll(List<O> objects) {
		if (null != objects && !(objects.isEmpty())) {
			for (O o : objects) {
				delete(o);
			}
		}
	}

	@SuppressWarnings({ "finally", "unchecked" })
	@Override
	public O getById(Serializable id) throws ObjectNotFoundException {
		O object = null;
		try {
			object = (O) sessionFactory.getCurrentSession().get(
					getDomainObjectClass(), id);
		} catch (HibernateException he) {
			throw new BaseCheckedException("查询出错！请检查数据库连接！");
		} finally {
			if (null != object) {
				return object;
			} else {
				throw new ObjectNotFoundException(getDomainObjectClass(),
						OBJECT_NOT_FOUND);
			}
		}
	}

	@Override
	public List<O> getByIds(List<Serializable> ids)
			throws ObjectNotFoundException {
		List<O> objects = new ArrayList<O>();
		if (ids != null) {
			for (Serializable id : ids) {
				objects.add(getById(id));
			}
		}
		return objects;
	}

	@Override
	public int deleteByIds(List<Serializable> ids) {
		int sum = 0;
		for (Serializable id : ids) {
			Object obj = sessionFactory.getCurrentSession().get(
					getDomainObjectClass(), id);
			if (obj != null) {
				sessionFactory.getCurrentSession().delete(obj);
				sum++;
			}
		}
		return sum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<O> search(List<Criterion> crits) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				getDomainObjectClass());
		if (crits != null) {
			for (Criterion ca : crits) {
				crit.add(ca);
			}
		}
		return crit.list();
	}

	@Override
	public long count() {
		return sessionFactory.getCurrentSession()
				.createCriteria(getDomainObjectClass()).list().size();
	}

}
