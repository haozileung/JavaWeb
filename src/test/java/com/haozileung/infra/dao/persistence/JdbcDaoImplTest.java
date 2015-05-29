package com.haozileung.infra.dao.persistence;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

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
		dao.insert(u);
		User user = dao.querySingleResult(Criteria.create(User.class).where(
				"name", new Object[] { "test" }));
		System.out.println(user);
		List<String> email = dao.queryForSimpleObjectList(
				"select email from t_user ", null, String.class);
		System.out.println(email);
	}

	@Test
	public void testInsertCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteClassOfQLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryListCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryListT() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryListTCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryCountObjectCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryCountObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryCountCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClassOfTLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCriteriaLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuerySingleResultT() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuerySingleResultCriteria() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBlobValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateForObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryForObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddForObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryForObjectList() {
		fail("Not yet implemented");
	}

	@Test
	public void testPageSearch() {
		fail("Not yet implemented");
	}

}
