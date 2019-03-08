package com.codecool.askmate.Services;

import com.codecool.askmate.Model.AuditionModel;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.DBPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
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
        System.out.println(postgresDb.findAll().size());
        return postgresDb.findAll();
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
        Question questionToUpdate = (Question)postgresDb.getOne(id);
        System.out.println(questionToUpdate);
        System.out.println(postgresDb.getOne(id));
        questionToUpdate.setDescription(question.getDescription());
        questionToUpdate.setShortDescription(question.getShortDescription());
        postgresDb.save(questionToUpdate);
    }

    public List<Question> searchWord(String word) {
        List<Question> searchWords = new ArrayList<>();
        List<Question> questionsList = postgresDb.findAll().stream().filter(auditionModel -> auditionModel instanceof Question).map(question -> (Question)question).collect(Collectors.toList());
        for (Question question : questionsList) {
            if (question.getDescription().contains(word) || question.getShortDescription().contains(word)) {
                searchWords.add(question);
            }
        }
        return searchWords;
    }
}
