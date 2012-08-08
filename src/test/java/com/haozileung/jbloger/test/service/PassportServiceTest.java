/**
 * 
 */
package com.haozileung.jbloger.test.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.haozileung.jbloger.dto.PassportInfo;
import com.haozileung.jbloger.service.PassportService;

/**
 * @author haozileung
 *
 */
//使用junit4进行测试


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({ "/spring/*-context.xml" }) 
@Transactional  
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)  
public class PassportServiceTest {
	
	@Autowired
	PassportService passportService;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.haozileung.jbloger.service.impl.PassportServiceImpl#addPassport(com.haozileung.jbloger.domain.Passport)}.
	 */
	@Test
	public void testAddPassport() {
		PassportInfo p = new PassportInfo();
		p.setEmail("haozileung.cn@gmail.com");
		p.setUserName("haozi");
		p.setPassword("123456");
		passportService.addPassport(p);
	}
}
