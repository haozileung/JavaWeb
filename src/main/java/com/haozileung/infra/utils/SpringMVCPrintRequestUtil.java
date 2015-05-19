package com.haozileung.infra.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;

public class SpringMVCPrintRequestUtil implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory
			.getLogger(SpringMVCPrintRequestUtil.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("*****************************************************************");
		logger.info("Input URL：" + request.getRequestURI());
		Enumeration<String> paramNames = request.getParameterNames();
		String[] emptyValues = new String[0];
		while (paramNames.hasMoreElements()) {// 遍历Enumeration
			String name = (String) paramNames.nextElement();// 取出下一个元素
			String[] value = MoreObjects.firstNonNull(
					request.getParameterValues(name), emptyValues);// 获取元素的值
			logger.info("{} = {}", name, Joiner.on(",").join(value));

		}
		logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
