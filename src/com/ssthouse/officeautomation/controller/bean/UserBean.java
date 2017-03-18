package com.ssthouse.officeautomation.controller.bean;

import com.ssthouse.officeautomation.domain.UserEntity;

public class UserBean {
	
	private String username;
	
	private String password;
	
	private boolean isAdmin;

	public UserBean(){
		
	}
	
	public UserBean(String username, String password, boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
