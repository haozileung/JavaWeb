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
import com.haozileung.manager.model.security.Resource;
import com.haozileung.manager.service.security.IResourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private IResourceService service;

	@RequestMapping({ "", "/" })
	public ModelAndView list(ModelAndView mv) {
		mv.setViewName("/security/resource/resources");
		return mv;
	}

	@RequestMapping("/page")
	public ModelAndView page(ModelAndView mv, Resource resource, Integer pageNo) {
		Pager pager = service.pageSearch(resource, pageNo);
		mv.addObject(pager);
		mv.setViewName("/security/resource/page");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv) {
		mv.setViewName("/security/resource/show");
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> doAdd(Resource resource) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.save(resource);
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
		Resource resource = service.getById(id);
		mv.addObject(resource);
		mv.setViewName("/security/resource/show");
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
	public Map<String, Object> update(Resource resource) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.update(resource);
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
	public Map<String, Object> save(Resource resource) {
		Map<String, Object> result = Maps.newHashMap();
		try {
			service.save(resource);
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
