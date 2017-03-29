package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.QuestionnaireEntity;

public interface IQuestionnaireDao {

	//TODO 用作测试用:  获取所有数据库中questionnaire
	List<QuestionnaireEntity> getAllQuestionnaire();
	
	void saveQuestionnaire(QuestionnaireEntity questionnaireEntity);
	
}
