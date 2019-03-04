package com.codecool.askmate.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private String author;
    private String shortDescription;

    private Date date;

    public Date getDate() {
        return date;
    }

    public Question() {
        this.date = new Date();
    }


    public Question(String description, String author, String shortDescription, int id) {
        this.description = description;
        this.author = author;
        this.shortDescription = shortDescription;
        this.date = new Date();
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
