package com.haozileung.jbloger.service;

import java.util.List;

import com.haozileung.jbloger.common.service.Service;
import com.haozileung.jbloger.dto.UserInfo;

public interface UserService extends Service{
	
	public void addUser(UserInfo userInfo);
	
	public List<UserInfo> getUserList();
	
	public void deleteUser(int id);
}
