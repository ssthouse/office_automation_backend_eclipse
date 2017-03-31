package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import com.google.gson.Gson;
import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.controller.tools.bean.AnswerAnalysisBean;
import com.ssthouse.officeautomation.controller.tools.bean.QuestionnaireAnswerBean;
import com.ssthouse.officeautomation.dao.IAnswerDao;
import com.ssthouse.officeautomation.domain.AnswerEntity;
import com.ssthouse.officeautomation.service.IAnswerService;

public class AnswerServiceImpl extends BaseService<IAnswerDao> implements IAnswerService{

	@Override
	public void saveAnswer(QuestionnaireAnswerBean answerBean, String username) {
		AnswerEntity answerEntity = new AnswerEntity();
		answerEntity.setAnswer(new Gson().toJson(answerBean.getAnswers()));
		answerEntity.setUsername(username);
		answerEntity.setQuestionnaireId(answerBean.getQuestionnaireId());
		getDao().saveAnswer(answerEntity);
	}

	@Override
	public AnswerAnalysisBean getAnswerAnalysis(int questionnaireId) {
		// TODO 获取问卷分析数据
		List<AnswerEntity> answerEntities = getDao().getAnswerList(questionnaireId);
		return new AnswerAnalysisBean();
	}

}
