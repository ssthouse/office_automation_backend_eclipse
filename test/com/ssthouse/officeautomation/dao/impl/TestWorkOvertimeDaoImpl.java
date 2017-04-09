package com.ssthouse.officeautomation.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;
import com.ssthouse.officeautomation.util.Log;

import sun.launcher.resources.launcher;

public class TestWorkOvertimeDaoImpl {

	private WorkOvertimeDaoImpl workOvertimeDaoImpl;
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		workOvertimeDaoImpl = context.getBean(WorkOvertimeDaoImpl.class);
	}

	@Test
	public void testSaveWorkOvertime() {
		WorkOvertimeEntity workOvertimeEntity = new WorkOvertimeEntity();
		workOvertimeEntity.setApproverUsername("ssthouse");
		workOvertimeEntity.setBeginDate("2017-11-12");
		workOvertimeEntity.setDescription("this is the description for test");
		workOvertimeEntity.setEndDate("2017-11-16");
		workOvertimeEntity.setHourNum(13);
		workOvertimeEntity.setIsHoliday(false);
		workOvertimeEntity.setState(WorkOvertimeEntity.STATE_DRAFT);
		workOvertimeEntity.setUsername("ssthouse");
		workOvertimeDaoImpl.saveWorkOvertime(workOvertimeEntity);
	}

	@Test
	public void testGetWorkOvertimeEntity() {
		WorkOvertimeEntity entity = workOvertimeDaoImpl.getWorkOvertimeEntity(1);
		Log.error("this is the entity which id  =  1 :");
		Log.error(new Gson().toJson(entity));
	}

	@Test
	public void testGetUserWorkOvertimeList() {
		List<WorkOvertimeEntity> userList = workOvertimeDaoImpl.getUserWorkOvertimeList("ssthouse");
		Log.error("this is the user list:");
		Log.error(new Gson().toJson(userList));
	}

	@Test
	public void testGetAdminWorkOvertimeList() {
		List<WorkOvertimeEntity> userList = workOvertimeDaoImpl.getAdminWorkOvertimeList("ssthouse");
		Log.error("this is the admin list:");
		Log.error(new Gson().toJson(userList));
	}

}
