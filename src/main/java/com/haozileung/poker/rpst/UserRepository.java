package com.haozileung.poker.rpst;

import java.util.List;

import com.haozileung.poker.common.domain.DomainObjectRepository;
import com.haozileung.poker.domain.User;
import com.haozileung.poker.dto.UserInfo;

public interface UserRepository extends DomainObjectRepository<User,UserInfo>{
	List<User> listUser();
	void deleteUser(int id);
}
