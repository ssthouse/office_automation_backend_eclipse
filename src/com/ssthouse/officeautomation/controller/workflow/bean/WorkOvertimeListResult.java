package com.ssthouse.officeautomation.controller.workflow.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;

public class WorkOvertimeListResult {

	private boolean ok;
	private String msg;
	private List<WorkOvertimeEntity> workOvertimeList;
	
	public WorkOvertimeListResult(boolean ok, String msg, List<WorkOvertimeEntity> workOvertimeList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.workOvertimeList = workOvertimeList;
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
	public List<WorkOvertimeEntity> getWorkOvertimeList() {
		return workOvertimeList;
	}
	public void setWorkOvertimeList(List<WorkOvertimeEntity> workOvertimeList) {
		this.workOvertimeList = workOvertimeList;
	}
	
}
