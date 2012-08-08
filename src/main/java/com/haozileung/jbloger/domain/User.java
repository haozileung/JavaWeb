package com.haozileung.jbloger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.haozileung.jbloger.common.domain.DomainInterface;
import com.haozileung.jbloger.dto.UserInfo;

@Entity
@Table(name="t_ssh_user")
public class User implements DomainInterface{

	private static final long serialVersionUID = 8254592767704044523L;
	private int id;
	private String name;
	private int age;
	
	public User(){
		
	}
	
	public User(UserInfo userInfo){
		update(userInfo);
	}
	
	private void update(UserInfo userInfo){
		this.age = userInfo.getAge();
		this.id = userInfo.getId();
		this.name = userInfo.getName();
	}
	
	@Id
	@GeneratedValue
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
	@Override
	public String toString() {
		return "name : "+name + " , age : "+age;
	}
	
}
