package com.haozileung.poker.action.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.poker.common.webapp.action.BasicAction;
import com.haozileung.poker.dto.UserInfo;
import com.haozileung.poker.service.UserService;

public class UserAction extends BasicAction{

	private static final long serialVersionUID = -8044906775297267551L;
	
	@Autowired
	private UserService userService;
	
	private UserInfo user ;
	
	private List<UserInfo> userList;
	
	private int userId;
	
	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String addUser(){
		userService.addUser(user);
		return "addUser";
	}

	public String fetchUserList(){
		userList = userService.getUserList();
		return "fetchUserList";
	}
	
	public String deleteUser(){
		LOG.info("要删除的id",""+userId);
		userService.deleteUser(userId);
		return "deleteUser";
	}
}
