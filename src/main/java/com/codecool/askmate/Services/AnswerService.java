package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Repositories.RepositoriesInterface.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answers) {
        this.answerRepository = answers;
    }

    public void addAnswer(Answer answer, Integer questionID) {
        answerRepository.addAnswer(answer, questionID);
    }

    public List<Answer> getAllAnswersByQuestionID(Integer id) {
        return answerRepository.getAllAnswersByQuestionID(id);
    }

    public void deleteAnswerById(Integer id) {
        answerRepository.removeAnswer(id);
    }

    public void editAnswer(Integer id, Answer answer) {
        answerRepository.editAnswer(id, answer);
    }

    public Answer getAnswerById(Integer id) {
        return answerRepository.getAnswerById(id);
    }
}
