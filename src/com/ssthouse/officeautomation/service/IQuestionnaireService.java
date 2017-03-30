package com.ssthouse.officeautomation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ssthouse.officeautomation.domain.QuestionnaireEntity;

public interface IQuestionnaireService {

	List<QuestionnaireEntity> getOpenQuestionnaireList(HttpServletRequest request);

	List<QuestionnaireEntity> getOwnedQuestionnaireList(HttpServletRequest request);

	/**
	 * 更新或保存问卷
	 * @param questionnaireEntity
	 */
	void saveOrUpdateQuestionnaire(QuestionnaireEntity questionnaireEntity);
}
