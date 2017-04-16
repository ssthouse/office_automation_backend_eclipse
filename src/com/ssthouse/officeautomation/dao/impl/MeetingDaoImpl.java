package com.ssthouse.officeautomation.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IMeetingDao;
import com.ssthouse.officeautomation.domain.MeetingEntity;

public class MeetingDaoImpl extends BaseDao implements IMeetingDao {

	@Override
	public void saveMeeting(MeetingEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateMeeting(MeetingEntity entity) {
		Session session = openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<MeetingEntity> getOpenMeetingList(String username) {
		Session session = openSession();
		session.beginTransaction();
		List<MeetingEntity> openMeetingList = session.createCriteria(MeetingEntity.class).list();
		session.getTransaction().commit();
		session.close();
		// filter data
		List<MeetingEntity> result = new ArrayList<>();
		for (MeetingEntity entity : openMeetingList) {
			List<String> participants = Arrays.asList(entity.getParticipant().split(","));
			if (participants.contains(username)) {
				result.add(entity);
			}
		}
		return result;
	}

	@Override
	public List<MeetingEntity> getOwnedMeetingList(String username) {
		Session session = openSession();
		session.beginTransaction();
		List<MeetingEntity> result = session.createCriteria(MeetingEntity.class)
				.add(Restrictions.eq("sponsor", username)).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
