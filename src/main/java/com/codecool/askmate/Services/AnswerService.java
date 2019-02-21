package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.HashMapQuestionRepository;
import com.codecool.askmate.Repositories.RepositoriesInterface.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answers;

    @Autowired
    public AnswerService(AnswerRepository answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        answers.addAnswer(answer);
    }

    public List<Answer> getAllAnswersByQuestionID(Integer id) {
        return answers.getAllAnswersByQuestionID(id);
    }

    public void deleteAnswerById(Integer id) {
        answers.removeAnswer(id);
    }

    public void editAnswer(Integer id, Answer answer) {
        answers.editAnswer(id, answer);
    }
}
