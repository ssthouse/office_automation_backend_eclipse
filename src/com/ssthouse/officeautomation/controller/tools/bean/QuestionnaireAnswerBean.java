package com.ssthouse.officeautomation.controller.tools.bean;

import java.util.List;

public class QuestionnaireAnswerBean {
	
	private int questionnaireId;
	
	private List<SingleAnswerBean> answers;

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public List<SingleAnswerBean> getAnswers() {
		return answers;
	}

	public void setAnswers(List<SingleAnswerBean> answers) {
		this.answers = answers;
	}
	
}
