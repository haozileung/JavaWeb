package com.haozileung.web.model.blog;

public class Tag {
	private Long id;
	private String name;

	public Tag(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
