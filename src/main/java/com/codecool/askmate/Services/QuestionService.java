package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.RepositoriesInterface.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questions) {
        this.questionRepository = questions;
    }

    @Transactional
    public void addQuestion(Question question) {
        questionRepository.addQuestion(question);
    }

    public Collection<Question> getAllQuetions() {
        return questionRepository.getAllQuestions();
    }

    public Question getQuestionByID(Integer id) {
        return questionRepository.getQuestionByID(id);
    }

    public void deleteQuestionById(int id) {
        questionRepository.removeQuestion(id);
    }

    public void editQuestion(Integer id, Question question) {
        questionRepository.editQuestion(id, question);
    }

    public List<Question> searchWord(String word) {
        List<Question> searchWords = new ArrayList<>();
        for (Question question : questionRepository.getAllQuestions()) {
            if (question.getDescription().contains(word) || question.getShortDescription().contains(word)) {
                searchWords.add(question);
            }
        }
        return searchWords;
    }
}
