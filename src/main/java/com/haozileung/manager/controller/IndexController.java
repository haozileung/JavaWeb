/**
 *
 */
package com.haozileung.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.haozileung.manager.dto.UserLoginForm;

/**
 * @author Haozi
 */
@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory
			.getLogger(IndexController.class);

	/**
	 * 首頁
	 *
	 * @return
	 */
	@RequestMapping({ "/index", "/", "" })
	public ModelAndView index(ModelAndView model) {
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(ModelAndView model, UserLoginForm form) {
		String email = form.getEmail();
		String password = form.getPassword();
		String rememberMe = form.getRememberMe();
		try {
			Preconditions.checkArgument(!Strings.isNullOrEmpty(email)
					&& !Strings.isNullOrEmpty(password));
		} catch (IllegalArgumentException e) {
			logger.error("参数异常", e);
			model.setViewName("redirect:/login");
			return model;
		}
		logger.debug("用户认证开始:{}, {}", email, password);
		UsernamePasswordToken token = new UsernamePasswordToken(email, password);
		Subject currentUser = SecurityUtils.getSubject();
		if (!Strings.isNullOrEmpty(rememberMe) && rememberMe.equals("yes")) {
			token.setRememberMe(true);
		}
		try {
			currentUser.login(token);
			logger.debug("用户认证完毕:{}", email);
			model.setViewName("redirect:/index.html");
			return model;
		} catch (UnknownAccountException uae) {
			logger.debug("用户认证失败:username wasn't in the system.");
		} catch (IncorrectCredentialsException ice) {
			logger.debug("用户认证失败:password didn't match.");
		} catch (LockedAccountException lae) {
			logger.debug("用户认证失败:account for that username is locked - can't login.");
		} catch (AuthenticationException ae) {
			logger.debug("用户认证失败:{}", ae.getMessage());
		}
		model.addObject("errorMsg", "登陆失败！");
		model.setViewName("/login");
		return model;
	}
}
