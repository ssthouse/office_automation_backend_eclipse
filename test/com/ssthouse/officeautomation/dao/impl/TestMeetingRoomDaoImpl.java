package com.ssthouse.officeautomation.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.MeetingRoomEntity;
import com.ssthouse.officeautomation.util.Log;

public class TestMeetingRoomDaoImpl {

	private MeetingRoomDaoImpl dao;
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		dao = context.getBean(MeetingRoomDaoImpl.class);
	}

	@Test
	public void testSave() {
		MeetingRoomEntity entity = new MeetingRoomEntity();
		entity.setAsset("电视, 桌子, 椅子");
		entity.setCapacity(100);
		entity.setName("第一会议室");
		dao.saveMeetingRoom(entity);
	}

	@Test
	public void testUpdate(){
		MeetingRoomEntity entity = dao.getMeetingRoom(1);
		entity.setName("第二会议室");
		dao.updateMeetingRoom(entity);
	}
	
	@Test
	public void testGetMeetingRoom(){
		MeetingRoomEntity entity = dao.getMeetingRoom(1);
		Log.error("this is the meetingRoom I get of id 1");
		Log.error(new Gson().toJson(entity));
	}
	
	@Test
	public void testGetList(){
		List<MeetingRoomEntity> list = dao.getMeetingRoomList();
		Log.error("there are all the meeting rooms:");
		Log.error(new Gson().toJson(list));
	}
}
