package com.ssthouse.officeautomation.dao.impl;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IUserDao;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.ssthouse.officeautomation.util.Log;

public class UserDaoImpl extends BaseDao implements IUserDao{

	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void test() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, 1);
        Log.error(userEntity.getUsername() + "  " + userEntity.getDescription()+"********"+userEntity.getIsAdmin());
    
	}

    /**
     * 返回的数据可能为 null
     */
	@Override
	public UserEntity getUserEntity(String username, String password, boolean isAdmin) {
		Log.error("isAdmin:  "+ isAdmin);
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		//byte isTure = 0;
		UserEntity userEntity = (UserEntity) session.createCriteria(UserEntity.class)
			.add(Restrictions.eq(UserEntity.COLUMN_USERNAME, username))
			.add(Restrictions.eq(UserEntity.COLUMN_PASSWORD, password))
			.add(Restrictions.eq(UserEntity.COLUMN_IS_ADMIN, isAdmin))
			.uniqueResult();
		return userEntity;
	}
	
	
}
