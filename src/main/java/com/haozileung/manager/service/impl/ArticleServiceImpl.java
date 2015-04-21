package com.haozileung.manager.service.impl;

import com.haozileung.manager.infra.dao.persistence.JdbcDao;
import com.haozileung.manager.model.blog.Article;
import com.haozileung.manager.service.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    private static final Logger logger = LoggerFactory
            .getLogger(IArticleService.class);

    @Autowired
    private JdbcDao dao;

    @Override
    public List<Article> pageSearch(Integer page, Integer pageSize) {
        logger.debug("service test...");
        return null;
    }

}
