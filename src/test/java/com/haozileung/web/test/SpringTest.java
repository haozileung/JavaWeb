package com.haozileung.web.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haozileung.infra.dao.persistence.Criteria;
import com.haozileung.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.security.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-main.xml",
		"classpath:applicationContext-datasource.xml" })
public class SpringTest {

	@Autowired
	private JdbcDao jdbcDao;

	@Test
	public void test() {
		// User u = new User();
		// u.setEmail("test");
		// u.setName("test");
		// u.setPassword("test");
		// jdbcDao.save(u);
		User u = jdbcDao.get(User.class, 1L);
		System.out.println(u);
	}

	@Test
	public void test2() {

		// 列表
		List<User> users = jdbcDao.queryList(Criteria.create(User.class).where(
				"id", "in", new Object[] { 1 }));
		// 总记录数
		System.out.println(users);
	}

}
