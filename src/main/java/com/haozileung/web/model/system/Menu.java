package com.haozileung.web.model.system;

import java.util.Set;

public class Menu {
	private Long id;
	private String name;
	private String url;
	private Integer orderNo;
	private Set<Menu> subMenu;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Set<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(Set<Menu> subMenu) {
		this.subMenu = subMenu;
	}
}
