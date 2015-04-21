package com.haozileung.manager.service;

import com.haozileung.manager.model.blog.Article;

import java.util.List;

public interface IArticleService {
	List<Article> pageSearch(Integer page, Integer pageSize);
}
