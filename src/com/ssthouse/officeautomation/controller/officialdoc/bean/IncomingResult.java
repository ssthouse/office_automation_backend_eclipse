package com.ssthouse.officeautomation.controller.officialdoc.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.IncomingEntity;

public class IncomingResult {

	private boolean ok;
	private String msg;
	private List<IncomingEntity> incomingList;
	
	public IncomingResult(boolean ok, String msg, List<IncomingEntity> incomingList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.incomingList = incomingList;
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
	public List<IncomingEntity> getIncomingList() {
		return incomingList;
	}
	public void setIncomingList(List<IncomingEntity> incomingList) {
		this.incomingList = incomingList;
	}
	
}
