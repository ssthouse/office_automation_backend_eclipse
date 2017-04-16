package com.ssthouse.officeautomation.controller.tools.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.MeetingEntity;

public class MeetingListResult {

	private boolean ok;
	private String msg;
	private List<MeetingEntity> meetingList;
	
	public MeetingListResult(boolean ok, String msg, List<MeetingEntity> meetingList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.meetingList = meetingList;
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

	public List<MeetingEntity> getMeetingList() {
		return meetingList;
	}

	public void setMeetingList(List<MeetingEntity> meetingList) {
		this.meetingList = meetingList;
	}
}
