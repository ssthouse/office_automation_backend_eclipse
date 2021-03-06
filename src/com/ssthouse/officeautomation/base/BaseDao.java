package com.ssthouse.officeautomation.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDao {
	
	// 从 spring 中配置的 sessionFactory
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

    public SessionFactory getSessionFactory(){
    	return sessionFactory;
    }
    
    public Session openSession(){
    	return sessionFactory.openSession();
    }
    
}
