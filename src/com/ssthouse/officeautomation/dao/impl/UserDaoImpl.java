package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IUserDao;
import com.ssthouse.officeautomation.domain.UserEntity;
import com.sun.management.jmx.Trace;

public class UserDaoImpl extends BaseDao implements IUserDao {

	/**
	 * 返回的数据可能为 null
	 */
	@Override
	public UserEntity getUserEntity(String username, String password, boolean isAdmin) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// byte isTure = 0;
		UserEntity userEntity = (UserEntity) session.createCriteria(UserEntity.class)
				.add(Restrictions.eq(UserEntity.COLUMN_USERNAME, username))
				.add(Restrictions.eq(UserEntity.COLUMN_PASSWORD, password))
				.add(Restrictions.eq(UserEntity.COLUMN_IS_ADMIN, isAdmin)).uniqueResult();
		transaction.commit();
		session.close();
		return userEntity;
	}

	@Override
	public UserEntity getUserEntity(String username) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		UserEntity userEntity = (UserEntity) session.createCriteria(UserEntity.class)
				.add(Restrictions.eq(UserEntity.COLUMN_USERNAME, username)).uniqueResult();
		transaction.commit();
		session.close();
		return userEntity;
	}

	@Override
	public void updateUserEntity(UserEntity userEntity) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(userEntity);
		transaction.commit();
		session.close();
	}

	@Override
	public List<UserEntity> getAllUser() {
		Session session = openSession();
		session.beginTransaction();
		List<UserEntity> userList = session.createCriteria(UserEntity.class).list();
		session.getTransaction().commit();
		session.close();
		return userList;
	}

}
