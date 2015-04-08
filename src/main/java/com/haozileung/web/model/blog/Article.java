package com.haozileung.web.model.blog;

import java.util.Date;
import java.util.Set;

import com.haozileung.web.model.security.User;

public class Article {
	private ArticleId id;
	private User author;
	private Set<Tag> tags;
	private Catalog catalog;
	private Set<Comment> comments;
	private Date createTime;
	private ArticleType type;
	private String content;

	public Article(ArticleId id) {
		this.id = id;
	}

	/**
	 * 添加評論
	 */
	public void addComment(Comment c) {
		comments.add(c);
	}

	/**
	 * 標記為移除
	 */
	public void markDelete() {
		this.type = ArticleType.DELETED;
	}

	public ArticleId getId() {
		return id;
	}

	public User getAuthor() {
		return author;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ArticleType getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public void setId(ArticleId id) {
		this.id = id;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setType(ArticleType type) {
		this.type = type;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
