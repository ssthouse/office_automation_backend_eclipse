package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IAnswerDao;
import com.ssthouse.officeautomation.domain.AnswerEntity;

public class AnswerDaoImpl extends BaseDao implements IAnswerDao {

	@Override
	public void saveAnswer(AnswerEntity answerEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(answerEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<AnswerEntity> getAnswerList(int questionnaireId) {
		Session session = openSession();
		session.beginTransaction();
		List<AnswerEntity> result = session.createCriteria(AnswerEntity.class)
				.add(Restrictions.eq("questionnaireId", questionnaireId)).list();
		return result;
	}

}
