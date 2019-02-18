package com.codecool.askmate.Model;

import java.util.Date;

public class Question {
    private String description;
    private String author;
    private String shortDescription;
    private Date releaseDate;

    public Question(String description, String author, String shortDescription, Date releaseDate) {
        this.description = description;
        this.author = author;
        this.shortDescription = shortDescription;
        this.releaseDate = releaseDate;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }



}
