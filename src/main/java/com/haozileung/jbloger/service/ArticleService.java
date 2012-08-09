package com.haozileung.jbloger.service;

import java.io.Serializable;
import java.util.List;

import com.haozileung.jbloger.common.service.Service;
import com.haozileung.jbloger.dto.ArticleInfo;

public interface ArticleService extends Service{
	
	public Serializable saveNewArticle(ArticleInfo articleInfo);
	
	public ArticleInfo findArticle(int aid);
	
	public List<ArticleInfo> findLeastArticle();

}
