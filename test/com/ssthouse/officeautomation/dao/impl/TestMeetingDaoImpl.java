package com.ssthouse.officeautomation.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.MeetingEntity;
import com.ssthouse.officeautomation.util.Log;

public class TestMeetingDaoImpl {

	private MeetingDaoImpl meetingDaoImpl;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		meetingDaoImpl = context.getBean(MeetingDaoImpl.class);
	}

	@Test
	public void testSaveMeeting() {
		MeetingEntity entity = new MeetingEntity();
		entity.setBeginDate("2007-11-11");
		entity.setBeginTime("10:00");
		entity.setEndTime("10:20");
		entity.setHoster("ssthouse");
		entity.setMeetingRoom("东九");
		entity.setParticipant("ssthouse,cgj,hqq,ytf");
		entity.setSponsor("ssthouse");
		entity.setTopic("hahahha");
		meetingDaoImpl.saveMeeting(entity);
	}

	@Test
	public void testUpdateMeeting() {
		MeetingEntity entity = meetingDaoImpl.getOpenMeetingList("ssthouse").get(0);
		entity.setHoster("cgj");
		meetingDaoImpl.updateMeeting(entity);
	}

	@Test
	public void testGetOpenMeetingList() {
		String result = new Gson().toJson(meetingDaoImpl.getOpenMeetingList("ssthouse"));
		Log.error("this is the open meeting list of ssthouse:");
		Log.error(result);
	}

	@Test
	public void testGetOwnedMeetingList() {
		String result = new Gson().toJson(meetingDaoImpl.getOwnedMeetingList("ssthouse"));
		Log.error("this is the owned meeting list of ssthouse:");
		Log.error(result);
	}

}
