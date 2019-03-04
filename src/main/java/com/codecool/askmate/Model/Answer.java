package com.codecool.askmate.Model;


import java.util.Date;

public class Answer {

    private String text;
    private String author;
    private Integer id;
    private Integer questionId;
    private Date date;


    public Answer() {
        this.date = new Date();
    }


    public Answer(String text, String author, Integer id, Integer questionId) {
        this.text = text;
        this.author = author;
        this.id = id;
        this.date = new Date();
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
