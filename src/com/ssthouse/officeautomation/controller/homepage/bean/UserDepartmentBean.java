package com.ssthouse.officeautomation.controller.homepage.bean;

import java.util.List;

public class UserDepartmentBean {

	private boolean ok;
	private String msg;
	
	private List<DepartmentBean> departmentList;

	public UserDepartmentBean(boolean ok, String msg, List<DepartmentBean> departmentList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.departmentList = departmentList;
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

	public List<DepartmentBean> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<DepartmentBean> departmentList) {
		this.departmentList = departmentList;
	}
	
}
