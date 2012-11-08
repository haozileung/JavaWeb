/**  
 * @Title: PassportInfo.java
 * @Package com.haozileung.poker.dto
 * @Description: Passport的传输类
 * @author haozi 
 * @date Aug 8, 2012 8:06:52 PM
 * @version V1.0  
 */
package com.haozileung.poker.dto;

import java.sql.Timestamp;

import com.haozileung.poker.common.dto.DataTransferObject;

/**
 * @ClassName: PassportInfo
 * @Description: Passport的传输类
 * @author haozi
 * @date Aug 8, 2012 8:06:52 PM
 * 
 */
public class PassportInfo implements DataTransferObject {

	/**
	 * @Fields serialVersionUID : 序列化版本ID
	 */
	private static final long serialVersionUID = -5797056219498129485L;

	/**
	 * @Fields passportId : 主键
	 */
	private int passportId;
	/**
	 * @Fields userName : 通行证名称
	 */
	private String userName;
	/**
	 * @Fields email : 电子邮件
	 */
	private String email;
	/**
	 * @Fields password : 密码
	 */
	private String password;
	/**
	 * @Fields lastLogin : 最后登陆时间
	 */
	private Timestamp lastLogin;
	/**
	 * @Fields loginIP : 最后登陆IP
	 */
	private String loginIP;

	// 下面是Getters和Setters
	/**
	 * @return the passportId
	 */
	public int getPassportId() {
		return passportId;
	}

	/**
	 * @param passportId
	 *            the passportId to set
	 */
	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastLogin
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 *            the lastLogin to set
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the loginIP
	 */
	public String getLoginIP() {
		return loginIP;
	}

	/**
	 * @param loginIP
	 *            the loginIP to set
	 */
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

}
