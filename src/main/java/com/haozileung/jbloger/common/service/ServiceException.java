package com.haozileung.jbloger.common.service;

import com.haozileung.jbloger.common.exception.BaseCheckedException;

public class ServiceException extends BaseCheckedException {

	private static final long serialVersionUID = 3419814986703271880L;

	public ServiceException(String msgKey, String message) {
		super(msgKey, message);
	}
	
	public ServiceException(String msgKey, String message, Object[] args) {
		super(msgKey, message, args);
	}

}
