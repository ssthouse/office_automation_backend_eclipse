package com.ssthouse.officeautomation.controller.homepage.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.DepartmentEntity;

public class DepartmentListBean {

	private boolean ok;
	private String msg;
	private List<DepartmentEntity> departmentList;
	
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
	public List<DepartmentEntity> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<DepartmentEntity> departmentList) {
		this.departmentList = departmentList;
	}
	public DepartmentListBean(boolean ok, String msg, List<DepartmentEntity> departmentList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.departmentList = departmentList;
	}
	
}
