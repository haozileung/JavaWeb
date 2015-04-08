package com.haozileung.web.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haozileung.web.model.blog.Article;
import com.haozileung.web.model.blog.ArticleId;
import com.haozileung.web.repository.IArticleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-main.xml",
		"classpath:applicationContext-datasource.xml" })
public class SpringTest {

	@Autowired
	private IArticleRepository repository;

	@Test
	public void test() {
		ArticleId aid = new ArticleId(1L);
		Article a1 = repository.load(aid);
		Article a2 = repository.load(aid);
		Assert.assertEquals(a1, a2);
	}

}
