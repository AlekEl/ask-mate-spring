package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class QuestionService {

    private JpaRepository<Question, Integer> postgresDb;

    //to use h2 database use @Qualifier("H2Db") in QuestionService constructor//

    @Autowired
    public QuestionService(JpaRepository postgresDb) {
        this.postgresDb = postgresDb;
    }

    @Transactional
    public void addQuestion(Question question) {
        postgresDb.save(question);
    }

    public Collection<Question> getAllQuestions() {
        System.out.println(postgresDb.findAll().size());
        return postgresDb.findAll();
    }

    public Question getQuestionByID(Integer id) {
        return postgresDb.findById(id).orElse(null);
    }

    @Transactional
    public void deleteQuestionById(Integer id) {
        postgresDb.deleteById(id);
    }

    @Transactional
    public void editQuestion(Integer id, Question question) {
        Question questionToUpdate = postgresDb.getOne(id);
        System.out.println(postgresDb.getOne(id));
        questionToUpdate.setDescription(question.getDescription());
        questionToUpdate.setShortDescription(question.getShortDescription());
        postgresDb.save(questionToUpdate);
    }

    public List<Question> searchWord(String word) {
        List<Question> searchWords = new ArrayList<>();
        List<Question> questionsList = postgresDb.findAll();
        for (Question question : questionsList) {
            if (question.getDescription().contains(word) || question.getShortDescription().contains(word)) {
                searchWords.add(question);
            }
        }
        return searchWords;
    }
}
