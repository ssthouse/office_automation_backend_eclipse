package com.ssthouse.officeautomation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseDao;
import com.ssthouse.officeautomation.dao.IQuestionnaireDao;
import com.ssthouse.officeautomation.domain.QuestionEntity;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;
import com.ssthouse.officeautomation.util.Log;

public class QuestionnaireDaoImpl extends BaseDao implements IQuestionnaireDao {

	private static final String COLUMN_CREATER_ID = "createrId";

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
		for (QuestionEntity questionEntity : questionnaireEntity.getQuestions()) {
			questionEntity.setQuestionnaireId(questionnaireEntity.getQuestionnaireId());
		}
		session.update(questionnaireEntity);
		transaction.commit();
	}

	@Override
	public List<QuestionnaireEntity> getOpenQuestionnaire(String username) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		List<QuestionnaireEntity> openList = session.createCriteria(QuestionnaireEntity.class).list();
		transaction.commit();
		return openList;
	}

	@Override
	public List<QuestionnaireEntity> getOwnedQuestionnaires(String createrId) {
		Session session = openSession();
		session.beginTransaction();
		List<QuestionnaireEntity> ownedList = session.createCriteria(QuestionnaireEntity.class)
				.add(Restrictions.eq(COLUMN_CREATER_ID, createrId)).list();
		session.getTransaction().commit();
		return ownedList;
	}

	@Override
	public void updateQuestionnaire(QuestionnaireEntity questionnaireEntity) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		session.update(questionnaireEntity);
		transaction.commit();
		session.close();
	}
}
