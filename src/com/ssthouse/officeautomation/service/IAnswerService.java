package com.ssthouse.officeautomation.service;

import java.util.List;

import com.ssthouse.officeautomation.controller.tools.bean.QuestionnaireAnswerBean;
import com.ssthouse.officeautomation.domain.QuestionnaireAnswerEntity;

public interface IAnswerService {

	/**
	 * 保存用户提交的问卷, 用户提交的格式为AnswerBean
	 * 
	 * @param answerBean
	 */
	void saveAnswer(QuestionnaireAnswerBean answerBean, String username);

	/**
	 * 获取指定问卷的分析结果
	 * 
	 * @param questionnaireId
	 * @return
	 */
	List<QuestionnaireAnswerEntity> getAnswerList(int questionnaireId);
}
