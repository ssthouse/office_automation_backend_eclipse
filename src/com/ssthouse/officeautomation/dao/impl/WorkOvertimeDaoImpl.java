package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IWorkOvertimeDao;
import com.ssthouse.officeautomation.domain.WorkOvertimeEntity;

public class WorkOvertimeDaoImpl extends BaseDao implements IWorkOvertimeDao {

	@Override
	public void saveWorkOvertime(WorkOvertimeEntity workOvertimeEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(workOvertimeEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public WorkOvertimeEntity getWorkOvertimeEntity(int id) {
		Session session = openSession();
		session.beginTransaction();
		WorkOvertimeEntity result = (WorkOvertimeEntity) session.createCriteria(WorkOvertimeEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<WorkOvertimeEntity> getUserWorkOvertimeList(String username) {
		return getWorkOvertimeList(WorkOvertimeEntity.PROPERTY_USERNME, username);
	}

	@Override
	public List<WorkOvertimeEntity> getAdminWorkOvertimeList(String approverUsername) {
		return getWorkOvertimeList(WorkOvertimeEntity.PROPERTY_APPROVER_USRNAME, approverUsername);
	}

	private List<WorkOvertimeEntity> getWorkOvertimeList(String propertyName, String propertyValue) {
		Session session = openSession();
		session.beginTransaction();
		List<WorkOvertimeEntity> result = session.createCriteria(WorkOvertimeEntity.class)
				.add(Restrictions.eq(propertyName, propertyValue)).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
}
