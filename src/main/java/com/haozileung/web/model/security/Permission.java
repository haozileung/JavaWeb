package com.haozileung.web.model.security;

public class Permission {
	private Long id;
	private PermissionType type;
	private String value;
	private Status status;

	public String getValue() {
		return value;
	}

	public PermissionType getType() {
		return type;
	}

	public Permission(PermissionType type, String value) {
		this.type = type;
		this.value = value;
	}

	public void changePermissonType(PermissionType type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}
}
