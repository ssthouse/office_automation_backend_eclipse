package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.domain.AnswerEntity;

public interface IAnswerDao {
	
	void saveAnswer(AnswerEntity answerEntity);

	List<AnswerEntity> getAnswerList(int questionnaireId);
}
