package com.ssthouse.officeautomation.dao.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.AskLeaveEntity;
import com.ssthouse.officeautomation.util.Log;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestAskLeaveDaoImpl {

	private AskLeaveDaoImpl askLeaveDaoImpl;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		askLeaveDaoImpl = context.getBean(AskLeaveDaoImpl.class);
	}

	@Test
	public void testSaveAskLeaveEntity() {
		AskLeaveEntity askLeaveEntity = new AskLeaveEntity();
		askLeaveEntity.setApproverUsername("ssthouse");
		askLeaveEntity.setBeginDate("2007-11-11");
		askLeaveEntity.setDayNum(3);
		askLeaveEntity.setDescription("description in short");
		askLeaveEntity.setEndDate("2006-00-11");
		askLeaveEntity.setLeaveType("sick");
		askLeaveEntity.setState("draft");
		askLeaveEntity.setUsername("ssthouse");
		askLeaveDaoImpl.saveAskLeaveEntity(askLeaveEntity);
	}

	@Test
	public void testUpdateAskLeaveEntity() {
		AskLeaveEntity oldEntity = askLeaveDaoImpl.getAskLeaveEntity(1);
		oldEntity.setDescription("I updated the description");
		askLeaveDaoImpl.updateAskLeaveEntity(oldEntity);
	}

	@Test
	public void testDeleteAskLeaveEntity() {
		AskLeaveEntity olfEntity = askLeaveDaoImpl.getAskLeaveEntity(1);
		askLeaveDaoImpl.deleteAskLeaveEntity(olfEntity);
	}

	@Test
	public void testGetAskLeaveEntity() {
		AskLeaveEntity askLeaveEntity = askLeaveDaoImpl.getAskLeaveEntity(2);
		Log.error("this is the askLeaveEntity I geted**************************");
		Log.error(new Gson().toJson(askLeaveEntity));
	}

	@Test
	public void testGetUserAskLeaveEntities() {
		List<AskLeaveEntity> entities = askLeaveDaoImpl.getUserAskLeaveEntities("ssthouse");
		Log.error("this is the entities I geted for ssthouse**************************");
		Log.error(new Gson().toJson(entities));
	}

	@Test
	public void testGetAdminAskLeaveEntities() {
		List<AskLeaveEntity> entities = askLeaveDaoImpl.getAdminAskLeaveEntities("ssthouse");
		Log.error("this is the entities I geted for ssthouse**************************");
		Log.error(new Gson().toJson(entities));
	}

}
