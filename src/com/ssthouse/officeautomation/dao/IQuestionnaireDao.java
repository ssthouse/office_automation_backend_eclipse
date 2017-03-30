package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.QuestionnaireEntity;

public interface IQuestionnaireDao {

	void saveQuestionnaire(QuestionnaireEntity questionnaireEntity);

	void updateQuestionnaire(QuestionnaireEntity questionnaireEntity);

	/**
	 * 获取对用户公开的questionnaire
	 * 
	 * @param username
	 * @return
	 */
	List<QuestionnaireEntity> getOpenQuestionnaire(String username);

	/**
	 * 获取用户管理的questionnaire
	 * 
	 * @param createrId
	 * @return
	 */
	List<QuestionnaireEntity> getOwnedQuestionnaires(String createrId);
}
