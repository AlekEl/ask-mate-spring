package com.codecool.askmate.Repositories.RepositoriesInterface;

import com.codecool.askmate.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface QuestionRepository {

    void addQuestion(Question question);

    void removeQuestion(Integer questionID);

    void editQuestion(int questionID, Question question);

    Collection<Question> getAllQuestions();

    Question getQuestionByID(Integer questionID);
}
