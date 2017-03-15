package com.ssthouse.officeautomation.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssthouse.officeautomation.entity.UserEntity;
import com.ssthouse.officeautomation.util.Log;

public class UserDaoImpl {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void test() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, 1);
        Log.error(userEntity.getUsername() + "  " + userEntity.getDescription());
    
	}
}
