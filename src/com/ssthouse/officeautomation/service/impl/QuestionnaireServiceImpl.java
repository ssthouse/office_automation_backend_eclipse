package com.ssthouse.officeautomation.service.impl;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IQuestionnaireDao;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;
import com.ssthouse.officeautomation.service.IQuestionnaireService;

public class QuestionnaireServiceImpl extends BaseService<IQuestionnaireDao> implements IQuestionnaireService{

	@Override
	public void saveQuestionnaire(QuestionnaireEntity questionnaireEntity) {
		getDao().saveQuestionnaire(questionnaireEntity);
	}

}
