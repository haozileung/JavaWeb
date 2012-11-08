package com.haozileung.poker.dto;

import java.sql.Timestamp;

import com.haozileung.poker.common.dto.DataTransferObject;
import com.haozileung.poker.domain.User;

public class UserLogInfo implements DataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5244300258759202934L;
	
	private int userLogId;

	private int operation;
	
	private int gold;
	
	private Timestamp opTime;
	
	private User user;

	public int getUserLogId() {
		return userLogId;
	}

	public void setUserLogId(int userLogId) {
		this.userLogId = userLogId;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Timestamp getOpTime() {
		return opTime;
	}

	public void setOpTime(Timestamp opTime) {
		this.opTime = opTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
