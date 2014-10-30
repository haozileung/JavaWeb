package com.haozileung.poker.rpst.impl;

import org.springframework.stereotype.Repository;

import com.haozileung.poker.common.domain.AbstractDomainRepository;
import com.haozileung.poker.domain.UserLog;
import com.haozileung.poker.dto.UserLogInfo;
import com.haozileung.poker.rpst.UserLogRepository;
@Repository("userLogRepository")
public class UserLogRepositoryImpl extends
		AbstractDomainRepository<UserLog, UserLogInfo> implements
		UserLogRepository {

	@Override
	protected Class<UserLog> getDomainObjectClass() {
		return UserLog.class;
	}

}
