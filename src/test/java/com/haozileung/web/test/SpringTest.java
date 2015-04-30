package com.haozileung.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haozileung.infra.utils.SpringContextUtil;
import com.haozileung.manager.service.task.UserRoleChangedEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-main.xml",
		"classpath:applicationContext-datasource.xml" })
public class SpringTest {

	@Test
	public void test() {
		UserRoleChangedEvent event = new UserRoleChangedEvent(this, 1L);
		SpringContextUtil.getApplicationContext().publishEvent(event);
		System.out.println("消息發送完成");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("退出測試");
	}
}
