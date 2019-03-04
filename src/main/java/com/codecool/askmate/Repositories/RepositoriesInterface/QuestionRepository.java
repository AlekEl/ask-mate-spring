package com.codecool.askmate.Repositories.RepositoriesInterface;

import com.codecool.askmate.Model.Question;

import java.util.Collection;

public interface QuestionRepository {
    void addQuestion(Question question);

    void removeQuestion(Integer questionID);

    void editQuestion(Integer questionID, Question question);

    Collection<Question> getAllQuestions();

    Question getQuestionByID(Integer questionID);
}
