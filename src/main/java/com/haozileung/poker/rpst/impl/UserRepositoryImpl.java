package com.haozileung.poker.rpst.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.haozileung.poker.common.domain.AbstractDomainRepository;
import com.haozileung.poker.domain.User;
import com.haozileung.poker.dto.UserInfo;
import com.haozileung.poker.rpst.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl extends AbstractDomainRepository<User,UserInfo> implements UserRepository {

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		Query query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.list();
	}
	
	public void deleteUser(int id){
		User user = new User();
		user.setUserId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	protected Class<User> getDomainObjectClass() {
		return User.class;
	}

}
