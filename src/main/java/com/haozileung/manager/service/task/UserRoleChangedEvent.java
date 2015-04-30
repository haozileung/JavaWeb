package com.haozileung.manager.service.task;

import org.springframework.context.ApplicationEvent;

public class UserRoleChangedEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1221143747836539030L;

	private Long uid;

	public UserRoleChangedEvent(Object source, Long uid) {
		super(source);
		this.uid = uid;
	}

	public Long getUid() {
		return uid;
	}
}
