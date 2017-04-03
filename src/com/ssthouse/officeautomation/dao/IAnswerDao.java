package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.QuestionnaireAnswerEntity;

public interface IAnswerDao {
	
	void saveAnswer(QuestionnaireAnswerEntity answerEntity);

	List<QuestionnaireAnswerEntity> getAnswerList(int questionnaireId);
}
