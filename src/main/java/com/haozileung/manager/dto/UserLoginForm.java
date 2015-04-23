/**
 * 
 */
package com.haozileung.manager.dto;

import java.io.Serializable;

/**
 * @author Haozi
 *
 */
public class UserLoginForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6848813521488672223L;

	private String email;
	
	private String password;
	
	private String rememberMe;

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

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

}
