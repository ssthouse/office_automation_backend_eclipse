package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.MeetingEntity;

public interface IMeetingDao {

	void saveMeeting(MeetingEntity entity);
	
	void updateMeeting(MeetingEntity entity);
	
	List<MeetingEntity> getOpenMeetingList(String username);
	
	List<MeetingEntity> getOwnedMeetingList(String username);
}
