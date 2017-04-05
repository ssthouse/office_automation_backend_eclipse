package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IAskLeaveDao;
import com.ssthouse.officeautomation.domain.AskLeaveEntity;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAskLeaveEntity(AskLeaveEntity askLeaveEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public AskLeaveEntity getAskLeaveEntity(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AskLeaveEntity> getUserAskLeaveEntities(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AskLeaveEntity> getAdminAskLeaveEntities(String approverUsername) {
		// TODO Auto-generated method stub
		return null;
	}

}
