package com.ssthouse.officeautomation.controller.bean;

public class SimpleResultBean {

	private boolean ok;

	public SimpleResultBean(boolean result) {
		super();
		this.ok = result;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean isSuccess) {
		this.ok = isSuccess;
	}

}
