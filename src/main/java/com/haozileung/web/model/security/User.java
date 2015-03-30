package com.haozileung.web.model.security;

import java.util.Set;

public class User {
	private Long id;
	private String name;
	private String password;
	private String email;
	private Set<Role> roles;
	private Status status;

	public void addRole(Role r) {
		this.roles.add(r);
	}

	public void updateName(String name) {
		this.name = name;
	}

	public void updatePassword(String password) {
		this.password = password;
	}

	public void enable() {
		this.status = Status.ENABLED;
	}

	public void disable() {
		this.status = Status.DISABLED;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public Status getStatus() {
		return status;
	}
}
