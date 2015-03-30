package com.haozileung.web.model.security;

import java.util.Set;

public class Role {
	private Long id;
	private String name;
	private Set<Permission> permissions;
	private Status status;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public Status getStatus() {
		return status;
	}
}
