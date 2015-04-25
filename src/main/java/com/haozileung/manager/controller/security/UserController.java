package com.haozileung.manager.controller.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.manager.model.security.User;
import com.haozileung.manager.service.security.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;

	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/security/user/users");
		return mv;
	}

	@RequestMapping("/page")
	public ModelAndView page(ModelAndView mv, User user, Integer pageNo) {
		Pager pager = service.pageSearch(user, pageNo);
		mv.addObject(pager);
		mv.setViewName("/security/user/page");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) {
		mv.setViewName("/security/user/show");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> doAdd(User user) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.save(user);
			result.put("status", 0);
			result.put("message", "添加成功");
		} catch (Exception e) {
			result.put("status", -1);
			result.put("message", e.getMessage());
		}
		return result;
	}

	@RequestMapping("/show")
	public ModelAndView show(ModelAndView mv, Long uid) {
		User user = service.getById(uid);
		mv.addObject(user);
		mv.setViewName("/security/user/show");
		return mv;
	}

	@RequestMapping("/ban")
	@ResponseBody
	public Map<String, Object> ban(Long uid) {
		Map<String, Object> result = Maps.newHashMap();
		service.ban(uid);
		result.put("status", 0);
		result.put("message", "状态修改成功");
		return result;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(User user) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.update(user);
			result.put("status", 0);
			result.put("message", "修改成功");
		} catch (Exception e) {
			result.put("status", -1);
			result.put("message", e.getMessage());
		}
		return result;
	}

	@RequestMapping("/save")
	@ResponseBody
	public Map<String, Object> save(User user) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.save(user);
			result.put("status", 0);
			result.put("message", "添加成功");
		} catch (Exception e) {
			result.put("status", -1);
			result.put("message", e.getMessage());
		}
		return result;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String, Object> delete(Long uid) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.delete(uid);
			result.put("status", 0);
			result.put("message", "删除成功");
		} catch (Exception e) {
			result.put("status", -1);
			result.put("message", e.getMessage());
		}
		return result;
	}
}
