package com.ssthouse.officeautomation.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ssthouse.officeautomation.base.BaseService;
import com.ssthouse.officeautomation.dao.IQuestionnaireDao;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;
import com.ssthouse.officeautomation.service.IQuestionnaireService;
import com.ssthouse.officeautomation.token.TokenManager;

public class QuestionnaireServiceImpl extends BaseService<IQuestionnaireDao> implements IQuestionnaireService {

	private static final int UNSAVED_QUESTIONNAIRE = 0;
	
	@Override
	public void saveQuestionnaire(QuestionnaireEntity questionnaireEntity) {
		if(questionnaireEntity.getQuestionnaireId() == UNSAVED_QUESTIONNAIRE){
			getDao().saveQuestionnaire(questionnaireEntity);
		}else{
			getDao().updateQuestionnaire(questionnaireEntity);
		}
	}

	@Override
	public List<QuestionnaireEntity> getOpenQuestionnaireList(HttpServletRequest request) {
		String username = TokenManager.getTokenUsername(request.getHeader("token"));
		return getDao().getOpenQuestionnaire(username);
	}

	@Override
	public List<QuestionnaireEntity> getOwnedQuestionnaireList(HttpServletRequest request) {
		String createrId = TokenManager.getTokenUsername(request.getHeader("token"));
		return getDao().getOwnedQuestionnaires(createrId);
	}

}
