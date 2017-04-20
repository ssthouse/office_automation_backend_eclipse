package com.ssthouse.officeautomation.dao.impl;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.DispatchEntity;
import com.ssthouse.officeautomation.util.Log;

public class TestDispatchDao {

	private DispatchDaoImpl dao;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		dao = context.getBean(DispatchDaoImpl.class);
	}

	@Test
	public void testSaveDispatch() {
		DispatchEntity entity = new DispatchEntity();
		entity.setBeginDate(System.currentTimeMillis());
		entity.setCheckComment("");
		entity.setContent("this is the content");
		entity.setCopyToOrganization("单位二");
		entity.setCountersign("");
		entity.setDeadline(System.currentTimeMillis());
		entity.setExecutors("ssthouse,cgj");
		entity.setOwner("ssthouse");
		entity.setState("begin");
		entity.setSign("");
		entity.setTargetOrganization("单位一");
		entity.setTitle("我是标题");
		entity.setType("决议");
		dao.saveDispatch(entity);
	}

	@Test
	public void testUpdateDispatch() {
		DispatchEntity entity = dao.getDispatch(1);
		entity.setContent("this is the changed content");
		dao.updateDispatch(entity);
	}

	@Test
	public void testGetDispatch() {
		DispatchEntity entity = dao.getDispatch(1);
		Log.error("this is the eneity with id: 1");
		Log.error(new Gson().toJson(entity));
	}

	@Test
	public void testGetUserDispatchList() {
		Log.error(new Gson().toJson(dao.getUserDispatchList("ssthouse")));
	}

	@Test
	public void testGetOwnedDispatchList() {
		Log.error(new Gson().toJson(dao.getOwnedDispatchList("ssthouse")));
	}

}
