package com.haozileung.jbloger.rpst.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haozileung.jbloger.domain.User;
import com.haozileung.jbloger.rpst.UserRepository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

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

}
