package com.haozileung.web.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.infra.utils.SpringContextUtil;
import com.haozileung.manager.model.security.User;
import com.haozileung.manager.service.task.UserRoleChangedEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-main.xml",
		"classpath:applicationContext-datasource.xml" })
public class SpringTest {

	@Test
	@Ignore
	public void test() {
		UserRoleChangedEvent event = new UserRoleChangedEvent(this, 1L);
		SpringContextUtil.getApplicationContext().publishEvent(event);
		System.out.println("消息發送完成");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("退出測試");
	}

	@Autowired
	private JdbcDao dao;

	@Test
	public void test2() {
		List<User> users = dao.queryList(Criteria.create(User.class));
		System.out.println(users);
	}
}
