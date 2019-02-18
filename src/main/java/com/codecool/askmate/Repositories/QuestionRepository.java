package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionRepository {


    Map<Integer, Question> questions = new HashMap<>();

    public QuestionRepository() {
        questions.put(1,new Question("s","s","s"));
        questions.put(2,new Question("a","a","a"));
        questions.put(3,new Question("d","d","d"));

    }

    public void addQuestion(Question question){

    }

    public void removeQuestion(Integer questionID){

    }

    public void editQuestion(Integer questionID){

    }

    public Collection<Question> getAllQuestions(){
        return questions.values();
    }

    public Question getQuestionByID(Integer questionID){
        return null;
    }
}
