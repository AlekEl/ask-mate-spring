package com.codecool.askmate.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "question")
public class Question extends AuditionModel{
    private String description;
    private String author;
    private String shortDescription;


    @OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE)
    private List<Answer> answers;

    private Date date;

    public Date getDate() {
        return date;
    }

    public Question() {
        super();
        this.date = new Date();
    }


    public Question(String description, String author, String shortDescription, int id) {
        super(id);
        this.description = description;
        this.author = author;
        this.shortDescription = shortDescription;
        this.date = new Date();
    }

    public Question(String description, String author, String shortDescription) {
        this.description = description;
        this.author = author;
        this.shortDescription = shortDescription;
        this.date = new Date();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

//    public Integer getId() {
//        return question_id;
//    }
//
//    public void setId(int id) {
//        this.question_id = id;
//    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", answers=" + answers +
                ", date=" + date +
                '}';
    }
}
