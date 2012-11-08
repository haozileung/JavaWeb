package com.haozileung.poker.action.user;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.poker.common.webapp.action.BasicAction;
import com.haozileung.poker.dto.PassportInfo;
import com.haozileung.poker.service.PassportService;

public class LoginAction extends BasicAction {

	@Autowired
	private PassportService passportService;

	private PassportInfo passport;


	public PassportInfo getPassport() {
		return this.passport;
	}

	public void setPassport(PassportInfo passport) {
		this.passport = passport;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727070490830332545L;

	@Override
	public String execute() throws Exception {
		passport.setLoginIP(request.getRemoteAddr());
		passport.setLastLogin(new Timestamp(new Date().getTime()));
		PassportInfo p = passportService.validatePassport(passport);
		if (p != null) {
			this.session.put("passport", p.getUserName());
			return SUCCESS;
		} else {
			return LOGIN;
		}
	}
}
