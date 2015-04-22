/**
 *
 */
package com.haozileung.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Haozi
 */
@Controller
public class IndexController {

	/**
	 * 首頁
	 *
	 * @return
	 */
	@RequestMapping({ "/index", "/", "" })
	public ModelAndView index(ModelAndView model) {
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		return model;
	}
}
