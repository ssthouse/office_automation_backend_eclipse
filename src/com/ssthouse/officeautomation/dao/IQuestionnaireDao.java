package com.ssthouse.officeautomation.dao;

import java.util.List;

import com.ssthouse.officeautomation.controller.bean.QuestionnaireBean;
import com.ssthouse.officeautomation.domain.QuestionnaireEntity;

public interface IQuestionnaireDao {

	//TODO 用作测试用:  获取所有数据库中questionnaire
	public List<QuestionnaireEntity> getAllQuestionnaire();
}
