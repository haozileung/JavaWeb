package com.haozileung.web.repository;

import com.haozileung.web.model.blog.Article;
import com.haozileung.web.model.blog.ArticleId;

public interface IArticleRepository {

	public Article load(ArticleId aid);

}
