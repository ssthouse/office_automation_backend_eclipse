package com.ssthouse.officeautomation.domain;

import javax.persistence.*;

/**
 * Created by ssthouse on 31/03/2017.
 */
@Entity
@Table(name = "answer", schema = "office_automation", catalog = "")
public class QuestionnaireAnswerEntity {
	
    private int id;
    private int questionnaireId;
    private String username;
    private String answer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "questionnaire_id", nullable = false)
    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "answer", nullable = false, length = 1000)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionnaireAnswerEntity that = (QuestionnaireAnswerEntity) o;

        if (id != that.id) return false;
        if (questionnaireId != that.questionnaireId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + questionnaireId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
