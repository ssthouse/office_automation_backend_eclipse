package com.ssthouse.officeautomation.controller.tools.bean;

import java.util.List;

import com.ssthouse.officeautomation.domain.QuestionnaireEntity;

public class QuestionnaireResultBean {

	private boolean ok;

	private String msg;

	private Data data;

	public QuestionnaireResultBean(boolean ok, String msg, Data data) {
		super();
		this.ok = ok;
		this.msg = msg;
		this.data = data;
	}

	public static class Data {

		private List<QuestionnaireEntity> questionnaireList;
		private List<QuestionnaireEntity> ownedQuestionnaireList;

		public Data(List<QuestionnaireEntity> questionnaireList, List<QuestionnaireEntity> ownedQuestionnaireList) {
			super();
			this.questionnaireList = questionnaireList;
			this.ownedQuestionnaireList = ownedQuestionnaireList;
		}

		public List<QuestionnaireEntity> getQuestionnaireList() {
			return questionnaireList;
		}

		public void setQuestionnaireList(List<QuestionnaireEntity> questionnaireList) {
			this.questionnaireList = questionnaireList;
		}

		public List<QuestionnaireEntity> getOwnedQuestionnaireList() {
			return ownedQuestionnaireList;
		}

		public void setOwnedQuestionnaireList(List<QuestionnaireEntity> ownedQuestionnaireList) {
			this.ownedQuestionnaireList = ownedQuestionnaireList;
		}
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
