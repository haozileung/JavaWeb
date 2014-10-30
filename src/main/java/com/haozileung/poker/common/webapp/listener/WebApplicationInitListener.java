/**
 * 
 */
package com.haozileung.poker.common.webapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.haozileung.poker.common.util.HashUtil;
import com.haozileung.poker.dto.PassportInfo;
import com.haozileung.poker.service.PassportService;

/**
 * 坚挺容器启动时，做初始化的设置
 */
public class WebApplicationInitListener implements ServletContextListener {

	private PassportService passportService;

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		ApplicationContext beans = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);
		passportService = (PassportService) beans.getBean("passportService");
		if (passportService.findPassportByUserName("admin") == null) {
			PassportInfo p = new PassportInfo();
			p.setUserName("admin");
			p.setPassword(HashUtil.doHash("123456"));
			p.setEmail("haozileung.cn@gmail.com");
			passportService.addPassport(p);
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {
		PassportInfo p = passportService.findPassportByUserName("admin");
		if (null != p){
			passportService.deletePassport(p.getPassportId());
		}
	}

}
