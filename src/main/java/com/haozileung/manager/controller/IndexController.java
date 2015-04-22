/**
 *
 */
package com.haozileung.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.haozileung.infra.dao.interceptor.PageControl;
import com.haozileung.infra.dao.pager.Pager;
import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.security.User;

/**
 * @author Haozi
 */
@Controller
public class IndexController {

	@Autowired
	private JdbcDao jdbcDao;

	/**
	 * 首頁
	 *
	 * @return
	 */
	@RequestMapping({ "/index", "/", "" })
	public ModelAndView index(ModelAndView model) {
		// 直接传入页码和每页条数
		PageControl.performPage(1, 10);
		// 使用Criteria方式，并指定排序字段方式为asc
		Criteria criteria = Criteria.create(User.class);
		jdbcDao.queryList(criteria);
		Pager pager = PageControl.getPager();
		// 列表
		List<User> users = pager.getList(User.class);
		// 总记录数
		Long itemsTotal = pager.getItemsTotal();
		System.out.println(users);
		System.out.println(itemsTotal);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model) {
		return model;
	}
}
