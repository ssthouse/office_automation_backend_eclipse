package com.ssthouse.officeautomation.controller.tools.bean;

import java.util.ArrayList;
import java.util.List;

import com.ssthouse.officeautomation.domain.VotingEntity;

public class OpenVotingListResult {

	private boolean ok;
	
	private String msg;
	
	private List<VotingEntity> openVotingList = new ArrayList<>();

	public OpenVotingListResult(boolean ok, String msg, List<VotingEntity> openVotingList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.openVotingList = openVotingList;
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

	public List<VotingEntity> getOpenVotingList() {
		return openVotingList;
	}

	public void setOpenVotingList(List<VotingEntity> openVotingList) {
		this.openVotingList = openVotingList;
	}
	
	
}
