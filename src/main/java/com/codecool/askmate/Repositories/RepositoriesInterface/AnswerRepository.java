package com.codecool.askmate.Repositories.RepositoriesInterface;

import com.codecool.askmate.Model.Answer;

import java.util.List;

public interface AnswerRepository {
    void addAnswer(Answer answer,Integer questionID);

    void removeAnswer(Integer answerID);

    void editAnswer(Integer answerID, Answer answer);

    List<Answer> getAllAnswersByQuestionID(Integer questionID);

    Answer getAnswerById(Integer id);
}
