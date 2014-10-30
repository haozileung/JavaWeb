package com.haozileung.poker.service;

import java.util.List;

import com.haozileung.poker.common.service.Service;
import com.haozileung.poker.dto.UserInfo;

public interface UserService extends Service{
	
	public void addUser(UserInfo userInfo);
	
	public List<UserInfo> getUserList();
	
	public void deleteUser(int id);
}
