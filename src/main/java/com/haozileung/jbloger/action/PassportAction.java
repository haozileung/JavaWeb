package com.haozileung.jbloger.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.jbloger.common.webapp.action.BasicAction;
import com.haozileung.jbloger.dto.PassportInfo;
import com.haozileung.jbloger.service.PassportService;

/**
 * @ClassName: PassportAction
 * @Description: Passport的Action
 * @author haozi
 * @date Aug 7, 2012 1:03:19 PM
 *
 */
public class PassportAction extends BasicAction {
	/**
	 * @Fields serialVersionUID : 版本UID
	 */
	private static final long serialVersionUID = 2210499454387420174L;

	/**
	 * @Fields passportService : 服务层的注入点
	 */
	@Autowired
	PassportService passportService;

	/**
	 * @Fields passport : 前台调用对象Passport
	 */
	private PassportInfo passport;
	/**
	 * @Fields id : 前台调用对象ID
	 */
	private int id;

	/**
	 * <p>Title: execute</p>
	 * <p>Description: </p>
	 * @return
	 * @throws Exception
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return "index";
	}

	/**
	 * @return the passport
	 */
	public PassportInfo getPassport() {
		return passport;
	}

	/**
	 * @param passport
	 *            the passport to set
	 */
	public void setPassport(PassportInfo passport) {
		this.passport = passport;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @Title: add
	 * @Description: 处理添加表单
	 * @param 参数
	 * @return String    返回类型
	 * @throws
	 */
	public String add() {
		passportService.addPassport(passport);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: 处理删除Passport的Action
	 * @param NULL
	 * @return String 返回类型
	 * @throws
	 */
	public String delete() {
		passportService.deletePassport(id);
		return SUCCESS;
	}

	/**
	 * @Title: update
	 * @Description: 处理更新
	 * @param 参数
	 * @return String    返回类型
	 * @throws
	 */
	public String update() {
		passportService.updatePassport(passport);
		return SUCCESS;
	}
}
