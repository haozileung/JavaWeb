package com.haozileung.poker.domain.support;

import com.haozileung.poker.common.service.AbstractDoToDtoConvertor;
import com.haozileung.poker.common.service.DoToDtoConvertorFactory;
import com.haozileung.poker.domain.User;
import com.haozileung.poker.dto.UserInfo;

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
		user.setBetMoney(obj.getBetMoney());
		user.setDesk(obj.getDesk());
		user.setHoldCard(obj.getHoldCard());
		user.setUserLog(obj.getUserLog());
		user.setPassport(obj.getPassport());
		user.setAssest(obj.getAssest());
		user.setUserId(obj.getUserId());
		user.setName(obj.getName());
		return user;
	}
}
