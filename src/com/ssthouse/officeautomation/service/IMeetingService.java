package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.domain.MeetingEntity;

public interface IMeetingService {

	void saveMeeting(MeetingEntity entity);
	
	void updateMeeting(MeetingEntity entity);
	
	List<MeetingEntity> getOpenMeetingList(String username);
	
	List<MeetingEntity> getOwnedMeetingList(String username);
}
