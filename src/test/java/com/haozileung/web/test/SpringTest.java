package com.haozileung.web.test;

import com.haozileung.infra.dao.persistence.JdbcDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-main.xml",
        "classpath:applicationContext-datasource.xml"})
public class SpringTest {

    @Autowired
    private JdbcDao dao;

    @Test
    public void test() {
    }

}
