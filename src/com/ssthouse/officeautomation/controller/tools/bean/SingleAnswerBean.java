package com.ssthouse.officeautomation.controller.tools.bean;

import java.util.ArrayList;
import java.util.List;

public class SingleAnswerBean {

	/**
	 * 题目在问卷中的序号
	 */
	private int index;

	private String type;

	/**
	 * 用于表示文字题答案
	 */
	private String answer;

	/**
	 * 用于表示选择题选项
	 */
	private List<String> selections = new ArrayList<>();

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getSelection() {
		return selections;
	}

	public void setSelection(List<String> selections) {
		this.selections = selections;
	}

}
