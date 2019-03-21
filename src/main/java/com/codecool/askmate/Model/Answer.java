package com.codecool.askmate.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answer")
public class Answer extends AuditionModel{

    private String text;
    private String author;
    private Integer question_id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "question_id",referencedColumnName = "qid", insertable = false, updatable = false)
    private Question question;





    public Answer(String text, String author, Integer id, Integer question_id) {
        super(id);
        this.text = text;
        this.author = author;
        this.date = new Date();
        this.question_id = question_id;
    }

    public Answer(Integer id) {
        super(id);
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

//    public Integer getId() {
//        return id;
//    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public void setQid(Integer id) {
//        this.id = id;
//    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return super.toString() + "text " + text +
        " author " + author +
        " date " + date +
        " question_id " + question_id;
    }
}
