package com.ssthouse.officeautomation.controller.bean;

import java.util.List;

public class QuestionnaireBean {

    /**
     * title : weewg
     * questions : [{"title":"questionOne","type":"radio","selections":"options1\noptions2"},{"title":"questionTwo","type":"checkbox","selections":"hahahah1\nhahahah2"}]
     * deadline : 2017-03-27T16:00:00.000Z
     */

    private String title;
    private String deadline;
    private List<QuestionsBean> questions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public List<QuestionsBean> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsBean> questions) {
        this.questions = questions;
    }

    public static class QuestionsBean {
        /**
         * title : questionOne
         * type : radio
         * selections : options1
         options2
         */

        private String title;
        private String type;
        private String selections;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSelections() {
            return selections;
        }

        public void setSelections(String selections) {
            this.selections = selections;
        }
    }
}
