package com.haozileung.jbloger.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.jbloger.common.webapp.action.BasicAction;
import com.haozileung.jbloger.dto.UserInfo;
import com.haozileung.jbloger.service.UserService;

public class UserAction extends BasicAction{

	private static final long serialVersionUID = -8044906775297267551L;
	
	@Autowired
	UserService userService;
	
	private UserInfo user ;
	
	private List<UserInfo> userList;
	
	private int id;
	
	public String addUser(){
		userService.addUser(user);
		return "addUser";
	}

	public String fetchUserList(){
		userList = userService.getUserList();
		return "fetchUserList";
	}
	
	public String deleteUser(){
		userService.deleteUser(id);
		return "deleteUser";
	}
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
