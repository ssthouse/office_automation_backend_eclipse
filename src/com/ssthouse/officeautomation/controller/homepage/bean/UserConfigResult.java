package com.ssthouse.officeautomation.controller.homepage.bean;

import com.ssthouse.officeautomation.domain.UserConfigEntity;

public class UserConfigResult {

	private boolean ok;
	private String msg;
	private UserConfigEntity userConfig;

	public UserConfigResult(boolean ok, String msg, UserConfigEntity userConfig) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.userConfig = userConfig;
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

	public UserConfigEntity getUserConfig() {
		return userConfig;
	}

	public void setUserConfig(UserConfigEntity userConfig) {
		this.userConfig = userConfig;
	}
}
