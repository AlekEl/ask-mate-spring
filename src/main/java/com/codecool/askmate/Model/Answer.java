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
    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "question.id")
    private Integer question_id;
    private Date date;


    public Answer() {
        this.date = new Date();
    }


    public Answer(String text, String author, Integer id, Integer question_id) {
        this.text = text;
        this.author = author;
        this.id = id;
        this.date = new Date();
        this.question_id = question_id;
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

    public Integer getQuestion_id() {
        return question_id;
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

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
