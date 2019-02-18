package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class questionService {

    private QuestionRepository questions;

    @Autowired
    public questionService(QuestionRepository questions) {
        this.questions = questions;
    }


    public Map<Integer, Question> getAllQuetions(){
        return questions.getAllQuestions();
    }
}
