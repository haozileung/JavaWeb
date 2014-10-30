package com.haozileung.poker.dto;

import java.util.HashSet;
import java.util.Set;

import com.haozileung.poker.common.dto.DataTransferObject;
import com.haozileung.poker.domain.Desk;
import com.haozileung.poker.domain.Passport;
import com.haozileung.poker.domain.UserLog;

public class UserInfo implements DataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 603438704919463320L;
	
	private int userId;	
	private Desk desk;
	private Passport passport;
	private Set<UserLog> userLog = new HashSet<UserLog>();
	private String name;
	private int assest;
	private int betMoney;
	private String holdCard;
	public UserInfo(){}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAssest() {
		return assest;
	}
	public void setAssest(int as) {
		this.assest = as;
	}
	public Desk getDesk() {
		return desk;
	}
	public void setDesk(Desk desk) {
		this.desk = desk;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public Set<UserLog> getUserLog() {
		return userLog;
	}
	public void setUserLog(Set<UserLog> userLog) {
		this.userLog = userLog;
	}
	public int getBetMoney() {
		return betMoney;
	}
	public void setBetMoney(int betMoney) {
		this.betMoney = betMoney;
	}
	public String getHoldCard() {
		return holdCard;
	}
	public void setHoldCard(String holdCard) {
		this.holdCard = holdCard;
	}
	

}
