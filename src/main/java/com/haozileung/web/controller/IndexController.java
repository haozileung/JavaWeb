/**
 * 
 */
package com.haozileung.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.MoreObjects;
import com.haozileung.web.service.IArticleService;

/**
 * @author Haozi
 *
 */
@Controller
public class IndexController {

	@Autowired
	private IArticleService service;

	/**
	 * 首頁
	 * 
	 * @return
	 */
	@RequestMapping({ "/index", "/", "" })
	public ModelAndView index(ModelAndView model, Integer page, Integer pageSize) {
		page = MoreObjects.firstNonNull(page, 0);
		pageSize = MoreObjects.firstNonNull(pageSize, 10);
		model.addObject("articles", service.pageSearch(page, pageSize));
		model.setViewName("/index");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		return model;
	}
}
