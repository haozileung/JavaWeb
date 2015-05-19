package com.haozileung.manager.model.blog;

import java.util.Date;

import com.haozileung.manager.model.security.User;

public class Comment {
	private Long id;
	private User author;
	private String content;
	private Date createTime;

	public User getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Long getId() {
		return id;
	}
}
