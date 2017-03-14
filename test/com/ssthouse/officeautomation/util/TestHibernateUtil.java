package com.ssthouse.officeautomation.util;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

//import com.ssthouse.officeautomation.entity.UserInfoEntity;

public class TestHibernateUtil {

	@Before
	public void setUp() throws Exception {
		 Session session = HibernateUtil.getSession();
	        session.beginTransaction();
	        //UserInfoEntity userInfoEntity = session.get(UserInfoEntity.class, 1);
	        //Log.error(userInfoEntity.getUsername() + "  " + userInfoEntity.getDescription());
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

}
