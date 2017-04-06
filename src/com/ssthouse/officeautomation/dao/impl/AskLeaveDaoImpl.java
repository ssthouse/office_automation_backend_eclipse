package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IAskLeaveDao;
import com.ssthouse.officeautomation.domain.AskLeaveEntity;
import com.ssthouse.officeautomation.util.Log;

public class AskLeaveDaoImpl extends BaseDao implements IAskLeaveDao {

	@Override
	public void saveAskLeaveEntity(AskLeaveEntity askLeaveEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(askLeaveEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateAskLeaveEntity(AskLeaveEntity askLeaveEntity) {
		Session session = openSession();
		session.beginTransaction();
		// id为0说明未被设置初始值, 抛出异常
		if (askLeaveEntity.getId() == 0) {
			Log.error("the id can't be 0");
			return;
		}
		session.update(askLeaveEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteAskLeaveEntity(AskLeaveEntity askLeaveEntity) {
		Session session = openSession();
		session.beginTransaction();
		if (askLeaveEntity.getId() == 0) {
			Log.error("the id can't be 0, delete fail");
			return;
		}
		session.delete(askLeaveEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public AskLeaveEntity getAskLeaveEntity(int id) {
		Session session = openSession();
		session.beginTransaction();
		AskLeaveEntity result = (AskLeaveEntity) session.createCriteria(AskLeaveEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<AskLeaveEntity> getUserAskLeaveEntities(String username) {
		Session session = openSession();
		session.beginTransaction();
		List<AskLeaveEntity> result = session.createCriteria(AskLeaveEntity.class)
				.add(Restrictions.eq("username", username)).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<AskLeaveEntity> getAdminAskLeaveEntities(String approverUsername) {
		Session session = openSession();
		session.beginTransaction();
		List<AskLeaveEntity> result = session.createCriteria(AskLeaveEntity.class)
				.add(Restrictions.eq("approverUsername", approverUsername)).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public void deleteAskLeaveEntity(int askLeaveEntityId) {
		AskLeaveEntity askLeaveEntity = getAskLeaveEntity(askLeaveEntityId);
		deleteAskLeaveEntity(askLeaveEntity);
	}

}
