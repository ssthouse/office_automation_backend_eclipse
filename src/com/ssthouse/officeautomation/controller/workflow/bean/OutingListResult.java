package com.ssthouse.officeautomation.controller.workflow.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.OutingEntity;

public class OutingListResult {

	private boolean ok;
	private String msg;
	private List<OutingEntity> outingList;

	public OutingListResult(boolean ok, String msg, List<OutingEntity> outingList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.outingList = outingList;
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

	public List<OutingEntity> getOutingList() {
		return outingList;
	}

	public void setOutingList(List<OutingEntity> outingList) {
		this.outingList = outingList;
	}
}
