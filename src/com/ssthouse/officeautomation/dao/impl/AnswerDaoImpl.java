package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IAnswerDao;
import com.ssthouse.officeautomation.domain.QuestionnaireAnswerEntity;

public class AnswerDaoImpl extends BaseDao implements IAnswerDao {

	@Override
	public void saveAnswer(QuestionnaireAnswerEntity answerEntity) {
		Session session = openSession();
		session.beginTransaction();
		session.save(answerEntity);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<QuestionnaireAnswerEntity> getAnswerList(int questionnaireId) {
		Session session = openSession();
		session.beginTransaction();
		List<QuestionnaireAnswerEntity> result = session.createCriteria(QuestionnaireAnswerEntity.class)
				.add(Restrictions.eq("questionnaireId", questionnaireId)).list();
		return result;
	}

}
