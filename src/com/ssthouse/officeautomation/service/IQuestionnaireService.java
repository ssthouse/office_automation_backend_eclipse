package com.ssthouse.officeautomation.service;

import com.ssthouse.officeautomation.domain.QuestionnaireEntity;

public interface IQuestionnaireService {

	/**
	 * 保存问卷到数据库 
	 * TODO: 后续需要标识  是谁创建的,  要给谁填....
	 * @param questionnaireEntity
	 */
	void saveQuestionnaire(QuestionnaireEntity questionnaireEntity);
}
