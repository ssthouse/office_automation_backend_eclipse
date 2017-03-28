package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IQuestionnaireDao;
import com.ssthouse.officeautomation.domain.QuestionEntity;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;

public class QuestionnaireDaoImpl extends BaseDao implements IQuestionnaireDao {

	@Override
	public List<QuestionnaireEntity> getAllQuestionnaire() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		List<QuestionnaireEntity> result = session.createCriteria(QuestionnaireEntity.class).list();
		return result;
	}

	public QuestionnaireEntity getQuestionnaire() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		QuestionnaireEntity result = (QuestionnaireEntity) session.createCriteria(QuestionnaireEntity.class)
				.uniqueResult();
		return result;
	}

	public List<QuestionEntity> getAllQuestion() {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		List<QuestionEntity> result = session.createCriteria(QuestionEntity.class).list();
		return result;
	}
}
