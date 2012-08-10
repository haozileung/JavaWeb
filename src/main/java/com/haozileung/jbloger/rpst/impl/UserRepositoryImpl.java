package com.haozileung.jbloger.rpst.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.haozileung.jbloger.common.domain.AbstractDomainRepository;
import com.haozileung.jbloger.domain.User;
import com.haozileung.jbloger.dto.UserInfo;
import com.haozileung.jbloger.rpst.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl extends AbstractDomainRepository<User,UserInfo> implements UserRepository {

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.list();
	}
	
	public void deleteUser(int id){
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	protected Class<User> getDomainObjectClass() {
		return User.class;
	}

}
