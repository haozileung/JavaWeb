package com.haozileung.web.model.security;

import java.util.Set;

public class Role {
	private Long id;
	private String name;
	private Set<Permission> permissions;
}
