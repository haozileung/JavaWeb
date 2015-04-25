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
import com.haozileung.manager.model.security.Role;
import com.haozileung.manager.service.security.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService service;

	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/security/role/roles");
		return mv;
	}

	@RequestMapping("/page")
	public ModelAndView page(ModelAndView mv, Role role, Integer pageNo) {
		Pager pager = service.pageSearch(role, pageNo);
		mv.addObject(pager);
		mv.setViewName("/security/role/page");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) {
		mv.setViewName("/security/role/show");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> doAdd(Role role) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.save(role);
			result.put("status", 0);
			result.put("message", "添加成功");
		} catch (Exception e) {
			result.put("status", -1);
			result.put("message", e.getMessage());
		}
		return result;
	}

	@RequestMapping("/show")
	public ModelAndView show(ModelAndView mv, Long id) {
		Role role = service.getById(id);
		mv.addObject(role);
		mv.setViewName("/security/role/show");
		return mv;
	}

	@RequestMapping("/ban")
	@ResponseBody
	public Map<String, Object> ban(Long id) {
		Map<String, Object> result = Maps.newHashMap();
		service.ban(id);
		result.put("status", 0);
		result.put("message", "状态修改成功");
		return result;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Map<String, Object> update(Role role) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.update(role);
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
	public Map<String, Object> save(Role role) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.save(role);
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
	public Map<String, Object> delete(Long id) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.delete(id);
			result.put("status", 0);
			result.put("message", "删除成功");
		} catch (Exception e) {
			result.put("status", -1);
			result.put("message", e.getMessage());
		}
		return result;
	}
}
