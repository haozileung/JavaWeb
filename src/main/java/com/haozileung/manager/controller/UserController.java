package com.haozileung.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.manager.model.security.User;
import com.haozileung.manager.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/system/user/users");
		return mv;
	}

	@RequestMapping("/page")
	public ModelAndView page(ModelAndView mv, String username, String email,
			Integer pageNo) {
		Pager pager = service.pageSearch(username, email, pageNo);
		mv.addObject(pager);
		mv.setViewName("/system/user/page");
		return mv;
	}

	@RequestMapping("/show")
	public ModelAndView show(ModelAndView mv, Long uid) {
		User user = service.getById(uid);
		mv.addObject(user);
		mv.setViewName("/system/user/show");
		return mv;
	}
}
