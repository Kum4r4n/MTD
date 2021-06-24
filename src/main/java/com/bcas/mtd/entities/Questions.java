package com.bcas.mtd.entities;

import com.bcas.mtd.helper.QuestionType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Questions extends BaseEntity{

    private String question;
    private String answer;
    private QuestionType questionType;

    public Questions() {
    }

    public Questions(String question, String answer, QuestionType questionType) {
        this.question = question;
        this.answer = answer;
        this.questionType = questionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }
}
