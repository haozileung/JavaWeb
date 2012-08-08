package com.haozileung.jbloger.domain.support;

import java.util.ArrayList;
import java.util.List;

import com.haozileung.jbloger.common.service.AbstractDoToDtoConvertor;
import com.haozileung.jbloger.common.service.DoToDtoConvertorFactory;
import com.haozileung.jbloger.domain.User;
import com.haozileung.jbloger.dto.UserInfo;

public class UserDoToDtoConvert extends AbstractDoToDtoConvertor<User, UserInfo> {
	
	private UserDoToDtoConvert() {
	}

	private static UserDoToDtoConvert instance;

	static {
		instance = new UserDoToDtoConvert();
		DoToDtoConvertorFactory.register(User.class, instance);
	}

	public static UserDoToDtoConvert getInstance() {
		return instance;
	}


	@Override
	public UserInfo doToDto(User obj) {
		UserInfo user = new UserInfo();
		user.setAge(obj.getAge());
		user.setId(obj.getId());
		user.setName(obj.getName());
		return user;
	}
	
	public List<UserInfo> dosToDtos(List<User> objs){
		if (null == objs){
			return null;
		}
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		for (User u : objs){
			userInfos.add(doToDto(u));
		}
		return userInfos;
	}
}
