package com.ssthouse.officeautomation.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ssthouse.officeautomation.util.StringUtil;

/**
 * Created by ssthouse on 27/03/2017.
 */
@Entity
@Table(name = "questionnaire", schema = "office_automation", catalog = "")
public class QuestionnaireEntity {
	private int questionnaireId;
	private String title;
	private String deadline;
	private String createrId;
	private boolean published;

	private List<QuestionEntity> questions = new ArrayList<QuestionEntity>();

	@OneToMany(mappedBy = "questionnaireId", targetEntity = QuestionEntity.class, cascade = { CascadeType.ALL })
	public List<QuestionEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionEntity> questionSet) {
		this.questions = questionSet;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionnaire_id", nullable = false)
	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "deadline", nullable = false, length = 30)
	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	@Basic
	@Column(name = "creater_id", nullable = false, length = 20)
	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	
	@Basic
	@Column(name="published", nullable = false, columnDefinition = "TINYINT(1)")
	public boolean getPublished(){
		return published;
	}
	
	public void setPublished(boolean published){
		this.published = published;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		QuestionnaireEntity that = (QuestionnaireEntity) o;

		if (questionnaireId != that.questionnaireId)
			return false;
		if (createrId != that.createrId)
			return false;
		if (title != null ? !title.equals(that.title) : that.title != null)
			return false;
		if (deadline != null ? !deadline.equals(that.deadline) : that.deadline != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = questionnaireId;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (deadline != null ? deadline.hashCode() : 0);
		result = 31 * result + (createrId != null ? createrId.hashCode() : 0);
		return result;
	}

	@Transient
	public boolean isValid() {
		if (StringUtil.isEmpty(title, deadline, createrId)) {
			return false;
		}
		if (questions == null || questions.size() == 0) {
			return false;
		}
		for (QuestionEntity questionEntity : questions) {
			if (!questionEntity.isValid()) {
				return false;
			}
		}
		return true;
	}
}
