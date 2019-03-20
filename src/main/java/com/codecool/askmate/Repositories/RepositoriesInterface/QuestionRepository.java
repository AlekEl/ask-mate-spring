package com.codecool.askmate.Repositories.RepositoriesInterface;

import com.codecool.askmate.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin(origins="http://localhost:4200")
public interface QuestionRepository extends JpaRepository<Question, Long> {

//    void addQuestion(Question question);
//
//    void removeQuestion(Integer questionID);
//
//    void editQuestion(int questionID, Question question);
//
//    Collection<Question> getAllQuestions();
//
//    Question getQuestionByID(Integer questionID);
}
