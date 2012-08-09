package com.haozileung.jbloger.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.haozileung.jbloger.common.domain.DomainInterface;
import com.haozileung.jbloger.dto.ArticleInfo;

@Entity
@Table(name = "t_ssh_article")
public class Article implements DomainInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1504960596467495147L;
	
	private int articleId;
	private String title;
	private String content;
	private Timestamp pubtime;
	private int authorId;
	private int comments;
	private int views;
	private int status;
	private int tags;
	
	public Article(){}
	
	public Article(ArticleInfo articleInfo){
		update(articleInfo);
	}
	
	private void update(ArticleInfo articleInfo){
		this.articleId = articleInfo.getArticleId();
		this.authorId = articleInfo.getAuthorId();
		this.title = articleInfo.getTitle();
		this.content = articleInfo.getContent();
		this.comments = articleInfo.getComments();
		this.views = articleInfo.getViews();
		this.tags = articleInfo.getTags();
		this.status = articleInfo.getStatus();
		this.pubtime = articleInfo.getPubtime();
	}
	
	@Id
	@GeneratedValue
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getPubtime() {
		return pubtime;
	}
	public void setPubtime(Timestamp pubtime) {
		this.pubtime = pubtime;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getTags() {
		return tags;
	}
	public void setTags(int tags) {
		this.tags = tags;
	}

}
