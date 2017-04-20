package com.ssthouse.officeautomation.controller.tools.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.MeetingRoomEntity;

public class MeetingRoomListResult {

	private boolean ok;
	private String msg;
	private List<MeetingRoomEntity> meetingRoomList;

	public MeetingRoomListResult(boolean ok, String msg, List<MeetingRoomEntity> meetingRoomList) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.meetingRoomList = meetingRoomList;
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

	public List<MeetingRoomEntity> getMeetingRoomList() {
		return meetingRoomList;
	}

	public void setMeetingRoomList(List<MeetingRoomEntity> meetingRoomList) {
		this.meetingRoomList = meetingRoomList;
	}
}
