package com.haozileung.web.model.system;

import java.util.Set;

public class Menu {
	private Long id;
	private String name;
	private String url;
	private Integer orderNo;
	private Set<Menu> subMenu;
}
