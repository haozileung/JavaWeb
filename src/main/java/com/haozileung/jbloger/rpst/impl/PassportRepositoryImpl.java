package com.haozileung.jbloger.rpst.impl;

import java.io.Serializable;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haozileung.jbloger.domain.Passport;
import com.haozileung.jbloger.rpst.PassportRepository;

@Repository("passportRepository")
public class PassportRepositoryImpl implements PassportRepository {
	
	public static final String OBJECT_NOT_FOUND = PassportRepository.class.getName().concat(".001");
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Serializable savePassport(Passport passport) {
		return sessionFactory.getCurrentSession().save(passport);
	}

	@Override
	public void deletePassport(int id) {
		Passport p = new Passport();
		p.setPassportId(id);
		sessionFactory.getCurrentSession().delete(p);
	}

	@Override
	public void updatePassport(Passport passport) {
		sessionFactory.getCurrentSession().update(passport);
	}

	@Override
	public Passport getPassportById(int id) {
		Object obj = sessionFactory.getCurrentSession().get(Passport.class, id);
		if (null == obj){
			throw new ObjectNotFoundException(OBJECT_NOT_FOUND,
					Passport.class.getSimpleName() + ".id = " + id
					+ " is not found!");
		}
		return (Passport) obj;
	}

}
