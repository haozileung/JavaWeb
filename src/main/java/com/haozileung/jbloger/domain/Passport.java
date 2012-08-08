package com.haozileung.jbloger.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.haozileung.jbloger.common.domain.DomainInterface;
import com.haozileung.jbloger.dto.PassportInfo;

@Entity
@Table(name = "t_ssh_passport")
public class Passport implements DomainInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8139959790448757610L;

	private int passportId;
	private String userName;
	private String email;
	private String password;
	private Timestamp lastLogin;
	private String loginIP;

	public Passport() {
	}
	
	public Passport(PassportInfo passportInfo){
		update(passportInfo);
	}
	
	private void update(PassportInfo passportInfo){
		this.email = passportInfo.getEmail();
		this.lastLogin = passportInfo.getLastLogin();
		this.loginIP = passportInfo.getLoginIP();
		this.passportId = passportInfo.getPassportId();
		this.password = passportInfo.getPassword();
		this.userName = passportInfo.getUserName();
	}

	@Id
	@GeneratedValue
	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
}
