package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.HashMapQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    private HashMapQuestionRepository questions;

    @Autowired
    public QuestionService(HashMapQuestionRepository questions) {
        this.questions = questions;
    }


    public void addQuestion(Question question) {
        questions.addQuestion(question);
    }

    public Collection<Question> getAllQuetions() {
        return questions.getAllQuestions();
    }

    public Question getQuestionByID(Integer id) {
        return questions.getQuestionByID(id);
    }

    public void deleteQuestionById(Integer id) {
        questions.removeQuestion(id);
    }

    public void editQuestion(Integer id, Question question) {
        questions.editQuestion(id, question);
    }

    public List<Question> searchWord(String word) {
        List<Question> searchWords = new ArrayList<>();
        for (Question question : questions.getAllQuestions()) {
            if (question.getDescription().contains(word) || question.getShortDescription().contains(word)) {
                searchWords.add(question);
            }
        }
        return searchWords;
    }
}
