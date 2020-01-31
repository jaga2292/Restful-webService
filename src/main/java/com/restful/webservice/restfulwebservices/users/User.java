package com.restful.webservice.restfulwebservices.users;

import java.util.Date;

public class User {

	private int id;
	private String name;
	private Date bithDate;
	
	
	public User() {	
	}

	public User(int id, String name, Date bithDate) {
		super();
		this.id = id;
		this.name = name;
		this.bithDate = bithDate;
	}
	
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
	public Date getBithDate() {
		return bithDate;
	}
	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", bithDate=" + bithDate + "]";
	}
	
	
	
}
