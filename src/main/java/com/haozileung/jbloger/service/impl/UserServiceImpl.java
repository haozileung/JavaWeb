package com.haozileung.jbloger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.jbloger.domain.User;
import com.haozileung.jbloger.domain.support.UserDoToDtoConvert;
import com.haozileung.jbloger.dto.UserInfo;
import com.haozileung.jbloger.rpst.UserRepository;
import com.haozileung.jbloger.service.UserService;

@Service("userService")
//@Transactional这是一种加事务的方式，还有一种是在spring配置文件中配置aop管理事务
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	public void addUser(UserInfo userInfo) {
		User user = new User(userInfo);
		userRepository.save(user);
	}

	public List<UserInfo> getUserList() {
		return UserDoToDtoConvert.getInstance().dos2Dtos(userRepository.search(null));
	}
	
	public void deleteUser(int id) {
		User u = userRepository.getById(id);
		if (u != null){
			userRepository.delete(u);
		}
	}

}
