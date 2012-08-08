package com.haozileung.jbloger.dto;

import com.haozileung.jbloger.common.dto.DataTransferObject;

public class UserInfo implements DataTransferObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 603438704919463320L;
	
	private int id;
	private String name;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
