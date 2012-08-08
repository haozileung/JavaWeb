package com.haozileung.jbloger.rpst;

import java.util.List;

import com.haozileung.jbloger.domain.User;

public interface UserRepository {
	
	void saveUser(User user);
	
	List<User> listUser();

	void deleteUser(int id);
	
}
