package com.ssthouse.officeautomation.controller.bean;

public class SimpleResultBean {

	private boolean success;

	public SimpleResultBean(boolean result) {
		super();
		this.success = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean isSuccess) {
		this.success = isSuccess;
	}

}
