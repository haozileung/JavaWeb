package com.haozileung.jbloger.common.exception;


/**
 * 需要检查的异常基类
 */
public class BaseCheckedException extends Exception {
	
	private static final long serialVersionUID = 3608778997258900435L;
	
	private String msgKey;
	public String getMsgKey() {
		return msgKey;
	}
	
	private Object[] args;
	public Object[] getArgs() {
		return args;
	}
	
	public BaseCheckedException(String msgKey) {
		super();
		this.msgKey=msgKey;
	}

	public BaseCheckedException(String msgKey,String message) {
		super(message);
		this.msgKey=msgKey;
	}
	
	public BaseCheckedException(String msgKey, String message, Object[] args) {
		super(message);
		this.msgKey=msgKey;
		this.args = args;
	}

}
