package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    private QuestionRepository questions;

    @Autowired
    public QuestionService(QuestionRepository questions) {
        this.questions = questions;
    }

    public Question getQuetionByID(){
        return questions.getQuestionByID(0);
    }

    public Collection<Question> getAllQuetions(){
        return questions.getAllQuestions();
    }

    public Question getQuestionByID(Integer id){
        return questions.getQuestionByID(id);
    }

    public void deleteQuestionById(Integer id) {
        questions.removeQuestion(id);
    }

}
