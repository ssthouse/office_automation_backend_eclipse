package com.ssthouse.officeautomation.controller.workflow.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.AskLeaveEntity;

public class AskLeaveEntitiesResult {

	private boolean ok;
	
	private String msg;
	
	private List<AskLeaveEntity> askLeaveList;
	
	public AskLeaveEntitiesResult(boolean ok, String msg, List<AskLeaveEntity> askLeaveList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.askLeaveList = askLeaveList;
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

	public List<AskLeaveEntity> getAskLeaveList() {
		return askLeaveList;
	}

	public void setAskLeaveList(List<AskLeaveEntity> askLeaveList) {
		this.askLeaveList = askLeaveList;
	}
}
