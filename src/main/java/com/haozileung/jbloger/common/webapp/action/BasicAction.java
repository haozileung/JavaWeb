package com.haozileung.jbloger.common.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class BasicAction extends ActionSupport implements SessionAware,ServletRequestAware{
	private static final long serialVersionUID = 1L;
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	
	public String exit(){
		session.clear();
		return "exit";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
