package com.ssthouse.officeautomation.controller.homepage.bean;

import com.ssthouse.officeautomation.domain.UserEntity;

public class UserResultBean {
	
	private boolean ok;
	
	private String msg;
	
	private UserEntity user;
	
	public UserResultBean(boolean ok, UserEntity user) {
		super();
		this.ok = ok;
		this.user = user;
	}

	public UserResultBean(boolean ok, String msg, UserEntity user) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.user = user;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
