package com.ssthouse.officeautomation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IDispatchDao;
import com.ssthouse.officeautomation.domain.DispatchEntity;

public class DispatchDaoImpl extends BaseDao implements IDispatchDao {

	@Override
	public void saveDispatch(DispatchEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateDispatch(DispatchEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();;
		session.close();
	}

	@Override
	public DispatchEntity getDispatch(int id) {
		Session session = openSession();
		session.beginTransaction();
		DispatchEntity result = (DispatchEntity) session.createCriteria(DispatchEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<DispatchEntity> getUserDispatchList(String username) {
		Session session = openSession();
		session.beginTransaction();
		List<DispatchEntity> dispatchList = session.createCriteria(DispatchEntity.class).list();
		List<DispatchEntity> result = new ArrayList<>();
		for (DispatchEntity entity : dispatchList) {
			String[] executorArray = entity.getExecutors().split(",");
			for (String executor : executorArray) {
				if (executor.equals(username)) {
					result.add(entity);
				}
			}
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<DispatchEntity> getOwnedDispatchList(String ownerUsername) {
		Session session = openSession();
		session.beginTransaction();
		List<DispatchEntity> result = session.createCriteria(DispatchEntity.class)
				.add(Restrictions.eq("owner", ownerUsername)).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
