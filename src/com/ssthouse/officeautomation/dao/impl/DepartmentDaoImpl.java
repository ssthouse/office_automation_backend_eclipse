package com.ssthouse.officeautomation.dao.impl;

import com.ssthouse.officeautomation.dao.IDepartmentDao;
import com.ssthouse.officeautomation.domain.DepartmentEntity;
import com.ssthouse.officeautomation.util.ResultHelper;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;

public class DepartmentDaoImpl extends BaseDao implements IDepartmentDao {

	@Override
	public void addApartment(DepartmentEntity apartmentEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(apartmentEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteApartment(DepartmentEntity apartmentEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.delete(apartmentEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateApartment(DepartmentEntity apartmentEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(apartmentEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public DepartmentEntity getApartment(int id) {
		Session session = openSession();
		session.beginTransaction();
		DepartmentEntity result = (DepartmentEntity) session.createCriteria(DepartmentEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public List<DepartmentEntity> getAllApartment() {
		Session session = openSession();
		session.beginTransaction();
		List<DepartmentEntity> result = session.createCriteria(DepartmentEntity.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
