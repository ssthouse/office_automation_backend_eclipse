package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IQuestionnaireDao;
import com.ssthouse.officeautomation.domain.QuestionEntity;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;
import com.ssthouse.officeautomation.util.Log;

public class QuestionnaireDaoImpl extends BaseDao implements IQuestionnaireDao {

	@Override
	public List<QuestionnaireEntity> getAllQuestionnaire() {
		Session session = openSession();
		session.beginTransaction();
		List<QuestionnaireEntity> result = session.createCriteria(QuestionnaireEntity.class).list();
		return result;
	}

	public QuestionnaireEntity getQuestionnaire() {
		Session session = openSession();
		session.beginTransaction();
		QuestionnaireEntity result = (QuestionnaireEntity) session.createCriteria(QuestionnaireEntity.class)
				.uniqueResult();
		return result;
	}

	public List<QuestionEntity> getAllQuestion() {
		Session session = openSession();
		session.beginTransaction();
		List<QuestionEntity> result = session.createCriteria(QuestionEntity.class).list();
		return result;
	}

	@Override
	public void saveQuestionnaire(QuestionnaireEntity questionnaireEntity) {
		Log.error(new Gson().toJson(questionnaireEntity));
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		session.save(questionnaireEntity);
		for(QuestionEntity questionEntity : questionnaireEntity.getQuestions()){
			questionEntity.setQuestionnaireId(questionnaireEntity.getQuestionnaireId());
		}
		session.update(questionnaireEntity);
		transaction.commit();
	}
}
