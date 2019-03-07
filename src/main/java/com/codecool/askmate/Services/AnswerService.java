package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.DBPostgres;
import com.codecool.askmate.Repositories.RepositoriesInterface.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class AnswerService {

    private DBPostgres answers;

    @Autowired
    public AnswerService(DBPostgres answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer, Integer question_id) {
        answer.setQuestion_id(question_id);
        answers.save(answer);
    }
//
//    public Collection<Answer> getAllAnswersByQuestion_id(Integer id) {
//        System.out.println(answers.findAll().size());
//        return answers.findAll();
//    }
    @Transactional
    public void deleteAnswerById(Integer id) {
        answers.d
    }



    public void editAnswer(Integer id, Answer answer) {
        Answer answer2update = answers.getOne(id);
        answer2update.setText(answer.getText());
        answers.save(answer2update);
        //TODO: Remove old one
    }

    public Answer getAnswerById(Integer id) {
        return answers.getOne(id);
    }
}
