package com.haozileung.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haozileung.web.model.blog.Article;
import com.haozileung.web.repository.security.IUserDao;
import com.haozileung.web.service.IArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	private static final Logger logger = LoggerFactory
			.getLogger(IArticleService.class);

	@Autowired
	private IUserDao articleRepository;

	@Override
	public List<Article> pageSearch(Integer page, Integer pageSize) {
		logger.debug("service test...");
		return null;
	}

}
