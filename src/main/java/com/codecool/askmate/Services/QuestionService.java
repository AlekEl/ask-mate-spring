package com.codecool.askmate.Services;

import com.codecool.askmate.Model.AuditionModel;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.DBPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RepositoryRestResource
public class QuestionService {

    private DBPostgres postgresDb;

    //to use h2 database use @Qualifier("H2Db") in QuestionService constructor//

    @Autowired
    public QuestionService(DBPostgres postgresDb) {
        this.postgresDb = postgresDb;
    }

    @Transactional
    public void addQuestion(Question question) {
        postgresDb.save(question);
    }

    public List<AuditionModel> getAllQuestions() {
        List<AuditionModel> allQuestions = postgresDb.findAll();
        return allQuestions;
    }

    public Question getQuestionByID(Integer id) {
        return (Question) postgresDb.findById(id).orElse(null);
    }

    @Transactional
    public void deleteQuestionById(Integer id) {
        postgresDb.deleteById(id);
    }

    @Transactional
    public void editQuestion(Integer id, Question question) {
        System.out.println(id);
        System.out.println(question);
        Question questionToUpdate = this.getQuestionByID(id);
        System.out.println(questionToUpdate);
        questionToUpdate.setDescription(question.getDescription());
        questionToUpdate.setShortDescription(question.getShortDescription());
        postgresDb.save(questionToUpdate);
    }

    public List<Question> searchWord(String word) {
        List<Question> searchWords = new ArrayList<>();
        List<Question> questionsList = postgresDb.findAll().stream().filter(auditionModel -> auditionModel instanceof Question).map(question -> (Question) question).collect(Collectors.toList());
        for (Question question : questionsList) {
            if (question.getDescription().contains(word) || question.getShortDescription().contains(word)) {
                searchWords.add(question);
            }
        }
        return searchWords;
    }
}
