package com.ssthouse.officeautomation.dao.impl;

import static org.junit.Assert.fail;

import org.apache.catalina.startup.UserConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.domain.UserConfigEntity;
import com.ssthouse.officeautomation.util.Log;

public class TestUserConfigDaoImol {

	private UserConfigDaoImpl userConfigDaoImpl;
	
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		userConfigDaoImpl = context.getBean(UserConfigDaoImpl.class);
	}

	@Test
	public void testSetUserConfig() {
		UserConfigEntity userConfigEntity = new UserConfigEntity();
		userConfigEntity.setUsername("ssthouse");
		userConfigDaoImpl.setUserConfig(userConfigEntity);
	}

	@Test
	public void testUpdateUserConfig() {
		UserConfigEntity entity = userConfigDaoImpl.getUserConfig("hahaha");
		userConfigDaoImpl.updateUserConfig(entity);
	}

	@Test
	public void testDeleteUserConfig() {
	}

	@Test
	public void testGetUserConfigInt() {
		UserConfigEntity entity = userConfigDaoImpl.getUserConfig("hahaha");
		Log.error("this is the userConfig eneity I get");
		Log.error(new Gson().toJson(entity));
	}

	@Test
	public void testGetUserConfigString() {
	}

}
