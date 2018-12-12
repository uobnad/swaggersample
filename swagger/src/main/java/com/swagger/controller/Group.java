package com.swagger.controller;

import java.util.List;

public class Group {
	
	public Group(String id, String name) {
		this.id=id;
		this.name=name;
	}
	
	private String id;
	private String name;
	private List<User> users;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
