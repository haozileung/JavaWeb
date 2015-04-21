package com.haozileung.manager.model.blog;

import com.haozileung.manager.model.security.User;

import java.util.Date;

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
