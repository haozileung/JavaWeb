package com.haozileung.manager.model.security;

import java.io.Serializable;

public class Permission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4454538113916660606L;
	private Long id;
	private Integer type;
	private String value;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
