package com.haozileung.jbloger.domain.support;

import java.util.ArrayList;
import java.util.List;

import com.haozileung.jbloger.common.service.AbstractDoToDtoConvertor;
import com.haozileung.jbloger.common.service.DoToDtoConvertorFactory;
import com.haozileung.jbloger.domain.Article;
import com.haozileung.jbloger.dto.ArticleInfo;

public class ArticleDoToDtoConvert extends AbstractDoToDtoConvertor<Article,ArticleInfo> {

	private ArticleDoToDtoConvert(){}
	
	private static ArticleDoToDtoConvert instance;
	
	static {
		instance = new ArticleDoToDtoConvert();
		DoToDtoConvertorFactory.register(Article.class, instance);
	}
	
	public static ArticleDoToDtoConvert getInstance(){
		return instance;
	}
	
	
	@Override
	public ArticleInfo doToDto(Article obj) {
		ArticleInfo articleInfo = new ArticleInfo();
		articleInfo.setArticleId(obj.getArticleId());
		articleInfo.setAuthorId(obj.getAuthorId());
		articleInfo.setComments(obj.getComments());
		articleInfo.setContent(obj.getContent());
		articleInfo.setPubtime(obj.getPubtime());
		articleInfo.setStatus(obj.getStatus());
		articleInfo.setTags(obj.getTags());
		articleInfo.setTitle(obj.getTitle());
		articleInfo.setViews(obj.getViews());
		return articleInfo;
	}
	
	public List<ArticleInfo> dosToDtos(List<Article> objs){
		List<ArticleInfo> articleInfos = new ArrayList<ArticleInfo>();
		for (Article article : objs){
			articleInfos.add(doToDto(article));
		}
		return articleInfos;
	}

}
