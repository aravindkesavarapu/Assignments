package com.capgemini.springcoreassign.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBean {
	
	private int id;
	
	@Autowired
	private UserBean userbean;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserBean getUserbean() {
		return userbean;
	}
	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}
	
	public void print() {
		userbean.display();
		
		System.out.println("Welcome to spring class-----"+"id------"+id);
	}

}
