package com.haozileung.poker.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haozileung.poker.domain.User;
import com.haozileung.poker.domain.support.UserDoToDtoConvert;
import com.haozileung.poker.dto.UserInfo;
import com.haozileung.poker.rpst.UserRepository;
import com.haozileung.poker.service.UserService;

@Service("userService")
// @Transactional这是一种加事务的方式，还有一种是在spring配置文件中配置aop管理事务
public class UserServiceImpl implements UserService {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	UserRepository userRepository;

	public void addUser(UserInfo userInfo) {
		User user = new User(userInfo);
		userRepository.save(user);
	}

	public List<UserInfo> getUserList() {
		// Search Null for all Objects
		return UserDoToDtoConvert.getInstance().dos2Dtos(
				userRepository.search(null));
		// return UserDoToDtoConvert.getInstance().dos2Dtos(
		// userRepository.listUser());
	}

	public void deleteUser(int id) {
		// userRepository.deleteUser(id);
		User u = userRepository.getById(id);
		if (u != null) {
			userRepository.delete(u);
		}
	}

}
