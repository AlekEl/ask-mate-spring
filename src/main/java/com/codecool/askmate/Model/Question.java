package com.codecool.askmate.Model;


import com.codecool.askmate.Repositories.QuestionRepository;

import java.util.Date;

public class Question {
    private String title;
    private String author;
<<<<<<< HEAD
    private String question;
=======
    private String shortDescription;
    private Integer id;
    private Date date;

>>>>>>> e80a5056e0760e763e1af058176b09e45515b1aa

    public Date getDate() {
        return date;
    }

<<<<<<< HEAD
    public Question(String title, String author, String question) {
        this.title = title;
        this.author = author;
        this.question = question;
=======
    public Question(String description, String author, String shortDescription, int id) {
        this.description = description;
        this.author = author;
        this.shortDescription = shortDescription;
        this.date = new Date();
        this.id = id;
>>>>>>> e80a5056e0760e763e1af058176b09e45515b1aa

    }

    public String getDescription() {
        return title;
    }

    public void setDescription(String description) {
        this.title = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDescription() {
        return question;
    }

    public void setShortDescription(String shortDescription) {
        this.question = shortDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
