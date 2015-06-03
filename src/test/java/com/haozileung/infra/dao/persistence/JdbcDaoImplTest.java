package com.haozileung.infra.dao.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.haozileung.manager.model.security.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-main.xml",
		"classpath:applicationContext-datasource.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "txManager")
public class JdbcDaoImplTest {

	@Autowired
	@Qualifier("jdbcTemplateDao")
	private JdbcDao dao;

	@Test
	public void testInsertObject() {
		User u = new User();
		u.setName("test");
		u.setPassword("password");
		u.setEmail("email");
		// dao.insert(u);
		dao.querySingleResult(Criteria.create(User.class).where("id",
				new Object[] { 1 }));
		dao.queryList(Criteria.create(User.class));
		User user = dao.querySingleResult(Criteria.create(User.class).where(
				"name", new Object[] { "test" }));
		System.out.println(user);
		List<String> email = dao.queryForSimpleObjectList(
				"select email from user ", null, String.class);
		System.out.println(email);
		String s = dao.queryForSimpleObject("select email from user limit 1",
				null, String.class);
		System.out.println(s);
	}
}
