package com.ssthouse.officeautomation.domain;

import javax.persistence.*;

/**
 * Created by ssthouse on 27/03/2017.
 */
@Entity
@Table(name = "question", schema = "office_automation", catalog = "")
public class QuestionEntity {
    private int id;
    private Integer questionnaireId;
    private String type;
    private String title;
    private String selections;
    
    @ManyToOne
    @JoinColumn(name="questionnaire_id")
    private QuestionnaireEntity questionnaireEntity;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "questionnaire_id", nullable = true)
    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "selections", nullable = true, length = 400)
    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections = selections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (id != that.id) return false;
        if (questionnaireId != null ? !questionnaireId.equals(that.questionnaireId) : that.questionnaireId != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (selections != null ? !selections.equals(that.selections) : that.selections != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (questionnaireId != null ? questionnaireId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (selections != null ? selections.hashCode() : 0);
        return result;
    }
}
