package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.MeetingRoomEntity;

public interface IMeetingRoomService {

	void saveMeetingRoom(MeetingRoomEntity entity);
	
	void updateMeetingRoom(MeetingRoomEntity entity);
	
	MeetingRoomEntity getMeetingRoomEntity(int id);
	
	List<MeetingRoomEntity> getMeetingRoomList();
}
