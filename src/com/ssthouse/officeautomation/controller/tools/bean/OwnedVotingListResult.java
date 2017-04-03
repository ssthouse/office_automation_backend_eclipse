package com.ssthouse.officeautomation.controller.tools.bean;

import java.util.ArrayList;
import java.util.List;

import com.ssthouse.officeautomation.domain.VotingEntity;

public class OwnedVotingListResult {

private boolean ok;
	
	private String msg;
	
	private List<VotingEntity> ownedVotingList = new ArrayList<>();

	public OwnedVotingListResult(boolean ok, String msg, List<VotingEntity> ownedVotingList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.ownedVotingList = ownedVotingList;
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

	public List<VotingEntity> getOwnedVotingList() {
		return ownedVotingList;
	}

	public void setOwnedVotingList(List<VotingEntity> ownedVotingList) {
		this.ownedVotingList = ownedVotingList;
	}
	
}
