package com.codecool.askmate.Model;


import com.codecool.askmate.Repositories.QuestionRepository;

import javax.validation.constraints.Size;
import java.util.Date;

public class Question {
    private String description;
    private String author;
    @Size(min = 10, max = 20)
    private String shortDescription;
    private Integer id;
    private Date date;


    public Date getDate() {
        return date;
    }

    public Question(String description, String author, String shortDescription, int id) {
        this.description = description;
        this.author = author;
        this.shortDescription = shortDescription;
        this.date = new Date();
        this.id = id;

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
