package com.haozileung.manager.service;

import java.util.List;

import com.haozileung.manager.model.blog.Article;

public interface IArticleService {
	List<Article> pageSearch(Integer page, Integer pageSize);
}
