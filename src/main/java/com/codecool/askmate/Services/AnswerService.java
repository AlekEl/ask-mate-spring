package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Repositories.DBPostgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


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
    @Transactional
    public void deleteAnswerById(Integer id) {
        answers.odeleteAnswerWithIds(id);
    }



    public void editAnswer(Integer id, Answer answer) {
        Answer answer2update = (Answer) answers.getOne(id);
        answer2update.setText(answer.getText());
        answers.save(answer2update);
        //TODO: Remove old one
    }

    public Answer getAnswerById(Integer id) {
        return (Answer) answers.getOne(id);
    }
}
