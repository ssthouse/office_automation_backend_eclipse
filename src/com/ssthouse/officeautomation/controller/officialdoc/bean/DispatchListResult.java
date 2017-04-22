package com.ssthouse.officeautomation.controller.officialdoc.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.DispatchEntity;

public class DispatchListResult {

	private boolean ok;
	private String msg;
	private List<DispatchEntity> dispatchList;
	
	public DispatchListResult(boolean ok, String msg, List<DispatchEntity> dispatchList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.dispatchList = dispatchList;
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
	public List<DispatchEntity> getDispatchList() {
		return dispatchList;
	}
	public void setDispatchList(List<DispatchEntity> dispatchList) {
		this.dispatchList = dispatchList;
	}
}
