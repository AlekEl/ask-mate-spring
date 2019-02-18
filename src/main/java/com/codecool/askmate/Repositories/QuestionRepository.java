package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class QuestionRepository {
    Map<Integer, Question> questions = new HashMap<>();

    public void addQuestion(Question question){

    }

    public void removeQuestion(Integer questionID){

    }

    public void editQuestion(Integer questionID){

    }

    public Map<Integer, Question> getAllQuestions(){
        return this.questions;
    }

    public Question getQuestionByID(Integer questionID){
        return null;
    }
}
