package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IMeetingRoomDao;
import com.ssthouse.officeautomation.domain.MeetingRoomEntity;

public class MeetingRoomDaoImpl extends BaseDao implements IMeetingRoomDao {

	@Override
	public void saveMeetingRoom(MeetingRoomEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateMeetingRoom(MeetingRoomEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public MeetingRoomEntity getMeetingRoom(int id) {
		Session session = openSession();
		session.beginTransaction();
		MeetingRoomEntity entity = (MeetingRoomEntity) session.createCriteria(MeetingRoomEntity.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return entity;
	}

	@Override
	public List<MeetingRoomEntity> getMeetingRoomList() {
		Session session = openSession();
		session.beginTransaction();
		List<MeetingRoomEntity> result = session.createCriteria(MeetingRoomEntity.class).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
