package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.MeetingRoomEntity;

public interface IMeetingRoomDao {

	void saveMeetingRoom(MeetingRoomEntity entity);
	
	void updateMeetingRoom(MeetingRoomEntity entity);
	
	MeetingRoomEntity getMeetingRoom(int id);
	
	List<MeetingRoomEntity> getMeetingRoomList();
}
