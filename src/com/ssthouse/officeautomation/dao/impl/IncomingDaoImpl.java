package com.ssthouse.officeautomation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IIncomingDao;
import com.ssthouse.officeautomation.domain.IncomingEntity;

public class IncomingDaoImpl extends BaseDao implements IIncomingDao {

	@Override
	public void saveIncomingEntity(IncomingEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateIncomingEntity(IncomingEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteIncomingEntity(int id) {
		// get the entity
		IncomingEntity entity = getIncomingEntity(id);
		// delete the entity
		Session session = openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public IncomingEntity getIncomingEntity(int id) {
		Session session = openSession();
		session.beginTransaction();
		IncomingEntity entity = (IncomingEntity) session.createCriteria(IncomingEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	@Override
	public List<IncomingEntity> getUserIncomings(String username) {
		Session session = openSession();
		session.beginTransaction();
		List<IncomingEntity> incomingList = session.createCriteria(IncomingEntity.class).list();
		List<IncomingEntity> result = new ArrayList<>();
		for (IncomingEntity entity : incomingList) {
			String[] executors = entity.getExecutors().split(",");
			for (String executor : executors) {
				if (executor.equals(username)) {
					result.add(entity);
					break;
				}
			}
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<IncomingEntity> getOwnerIncomings(String ownerUsername) {
		Session session = openSession();
		session.beginTransaction();
		List<IncomingEntity> result = session.createCriteria(IncomingEntity.class)
				.add(Restrictions.eq("owner", ownerUsername)).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
