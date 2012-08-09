package com.haozileung.jbloger.dto;

import java.sql.Timestamp;

import com.haozileung.jbloger.common.dto.DataTransferObject;

public class ArticleInfo implements DataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8575019049591320977L;
	
	private int articleId;
	private String title;
	private String content;
	private Timestamp pubtime;
	private int authorId;
	private int comments;
	private int views;
	private int status;
	private int tags;
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
