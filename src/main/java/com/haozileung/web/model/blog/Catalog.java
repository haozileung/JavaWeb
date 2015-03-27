package com.haozileung.web.model.blog;

public class Catalog {
	private Long id;
	private String name;
	public Catalog(Long id, String name) {
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
