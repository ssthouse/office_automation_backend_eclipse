package com.ssthouse.officeautomation.controller.bean;

public class SimpleResultBean {

	private boolean ok;
	
	private String msg;

	public SimpleResultBean(boolean ok, String msg) {
		super();
		this.ok = ok;
		this.msg = msg;
	}
	
	public SimpleResultBean(boolean ok){
		super();
		this.ok = ok;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean isSuccess) {
		this.ok = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
