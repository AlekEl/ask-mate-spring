package com.codecool.askmate.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Question questionId;
    private Date date;


    public Answer() {
        this.date = new Date();
    }


    public Answer(String text, String author, Integer id, Question questionId) {
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

    public Question getQuestionId() {
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

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
