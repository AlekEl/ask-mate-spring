package com.codecool.askmate.Model;


import java.util.Date;


public class Question {
    private String title;
    private String author;
    private String question;


    public Question(String title, String author, String question) {
        this.title = title;
        this.author = author;
        this.question = question;

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




}
