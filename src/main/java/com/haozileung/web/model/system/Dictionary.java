package com.haozileung.web.model.system;

import java.util.Set;

public class Dictionary {
	private Long id;
	private String code;
	private String value;
	private Integer orderNo;
	private Set<Dictionary> dics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Set<Dictionary> getDics() {
		return dics;
	}

	public void setDics(Set<Dictionary> dics) {
		this.dics = dics;
	}
}
