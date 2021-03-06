package com.swagger.controller;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

public class User {
	
	public User(String id, String name) {
		this.id=id;
		this.name=name;
	}
	@ApiModelProperty(value = "[UID", required=true)
	private String id;
	private String name;
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
	
	

}
