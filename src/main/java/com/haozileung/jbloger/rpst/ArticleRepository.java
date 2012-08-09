package com.haozileung.jbloger.rpst;

import java.io.Serializable;

import org.hibernate.Criteria;

import com.haozileung.jbloger.domain.Article;

public interface ArticleRepository {
	
	public Article findArticle(Criteria criteria);
	
	public void deleteArticle(Criteria criteria);
	
	public void updateArticle(Article article);
	
	public Serializable saveArticle(Article article);

}
