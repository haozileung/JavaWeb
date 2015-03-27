package com.haozileung.web.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.haozileung.web.repository.IArticleRepository;

@Repository
public class ArticleRepositoryImpl implements IArticleRepository {
	private static final Logger logger = LoggerFactory
			.getLogger(IArticleRepository.class);

}
