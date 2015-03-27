package com.haozileung.web.service;

import java.util.List;

import com.haozileung.web.model.blog.Article;

public interface IArticleService {
	public List<Article> pageSearch(Integer page, Integer pageSize);
}
