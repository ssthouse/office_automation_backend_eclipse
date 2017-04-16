package com.ssthouse.officeautomation.dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IUserConfigDao;
import com.ssthouse.officeautomation.domain.UserConfigEntity;

public class UserConfigDaoImpl extends BaseDao implements IUserConfigDao {

	@Override
	public void setUserConfig(UserConfigEntity userConfigEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(userConfigEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateUserConfig(UserConfigEntity userConfigEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(userConfigEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteUserConfig(int id) {
		Session session = openSession();
		session.beginTransaction();
		UserConfigEntity entity = getUserConfig(id);
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public UserConfigEntity getUserConfig(int id) {
		Session session = openSession();
		session.beginTransaction();
		UserConfigEntity entity = (UserConfigEntity) session.createCriteria(UserConfigEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	@Override
	public UserConfigEntity getUserConfig(String username) {
		Session session = openSession();
		session.beginTransaction();
		UserConfigEntity entity = (UserConfigEntity) session.createCriteria(UserConfigEntity.class)
				.add(Restrictions.eq("username", username)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return entity;
	}

}
