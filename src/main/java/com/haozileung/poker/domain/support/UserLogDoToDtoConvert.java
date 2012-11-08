package com.haozileung.poker.domain.support;

import com.haozileung.poker.common.service.AbstractDoToDtoConvertor;
import com.haozileung.poker.common.service.DoToDtoConvertorFactory;
import com.haozileung.poker.domain.UserLog;
import com.haozileung.poker.dto.UserLogInfo;

public class UserLogDoToDtoConvert extends
		AbstractDoToDtoConvertor<UserLog, UserLogInfo> {

	private UserLogDoToDtoConvert() {
	}

	private static UserLogDoToDtoConvert instance;

	static {
		instance = new UserLogDoToDtoConvert();
		DoToDtoConvertorFactory.register(UserLog.class, instance);
	}

	public static UserLogDoToDtoConvert getInstance() {
		return instance;
	}

	@Override
	public UserLogInfo doToDto(UserLog obj) {
		if (obj == null) {
			return null;
		}
		UserLogInfo userLogInfo = new UserLogInfo();
		userLogInfo.setGold(obj.getGold());
		userLogInfo.setOperation(obj.getOperation());
		userLogInfo.setOpTime(obj.getOpTime());
		userLogInfo.setUser(obj.getUser());
		userLogInfo.setUserLogId(obj.getUserLogId());
		return userLogInfo;
	}
}
