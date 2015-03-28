package com.haozileung.web.model.security;

import java.util.Set;

public class User {
	private Long id;
	private String name;
	private String password;
	private String email;
	private Set<Role> roles;
	private Status status;
}
