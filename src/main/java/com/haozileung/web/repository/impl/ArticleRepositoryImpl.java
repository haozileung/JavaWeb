package com.haozileung.web.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.haozileung.web.model.blog.Article;
import com.haozileung.web.model.blog.ArticleId;
import com.haozileung.web.repository.IArticleRepository;

@Repository
public class ArticleRepositoryImpl implements IArticleRepository {
	private static final Logger logger = LoggerFactory
			.getLogger(IArticleRepository.class);

	@Cacheable(value = "Article", key = "#aid.value")
	@Override
	public Article load(ArticleId aid) {
		logger.debug("開始從數據庫加載文章ID:{}", aid.getValue());
		return null;
	}

	@CacheEvict(value = "Article", key = "#aid.value")
	public void delete(ArticleId aid) {
		logger.debug("從數據庫刪除文章ID:{}", aid.getValue());
	}

	@CachePut(value = "Article", key = "#result.id.value")
	public Article update(Article art) {
		return art;
	}

	@Cacheable(value = "Article", key = "#result.id.value")
	public Article add(Article art) {
		return art;
	}
}
