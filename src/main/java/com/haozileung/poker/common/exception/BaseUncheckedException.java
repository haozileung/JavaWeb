/**
 * 
 */
package com.haozileung.poker.common.exception;

/**
 * 不需要检查的异常基类
 */
public class BaseUncheckedException extends RuntimeException {
	
	private static final long serialVersionUID = -1993410383498751491L;
	
	private String msgKey;

	public BaseUncheckedException(String msgKey,String message, Throwable throwable) {
		super(message, throwable);
		this.msgKey=msgKey;
	}
	
	public BaseUncheckedException(String msgKey,String message) {
		super(message);
		this.msgKey=msgKey;
	}
	
	public BaseUncheckedException(String message) {
		super(message);
		this.msgKey=null;
	}
	
	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}
	
}
