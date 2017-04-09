package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IOutingDao;
import com.ssthouse.officeautomation.domain.OutingEntity;

public class OutingDaoImpl extends BaseDao implements IOutingDao {

	@Override
	public void saveOutingEntity(OutingEntity outingEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(outingEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateOutingEntity(OutingEntity outingEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(outingEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteOutingEntity(int id) {
		OutingEntity entity = getOutingEntity(id);
		Session session = openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public OutingEntity getOutingEntity(int id) {
		Session session = openSession();
		session.beginTransaction();
		OutingEntity outingEntity = (OutingEntity) session.createCriteria(OutingEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return outingEntity;
	}

	@Override
	public List<OutingEntity> getUserOutingEntities(String username) {
		Session session = openSession();
		session.beginTransaction();
		List<OutingEntity> list = session.createCriteria(OutingEntity.class).add(Restrictions.eq("username", username))
				.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<OutingEntity> getAdminOutingEntities(String approverUsername) {
		Session session = openSession();
		session.beginTransaction();
		List<OutingEntity> list = session.createCriteria(OutingEntity.class)
				.add(Restrictions.eq("approverUsername", approverUsername)).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

}
