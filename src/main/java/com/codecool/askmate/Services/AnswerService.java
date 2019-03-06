package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Repositories.RepositoriesInterface.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AnswerService {

    private JpaRepository<Answer, Integer> answers;

    @Autowired
    public AnswerService(JpaRepository answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer, Integer question_id) {
        answers.save(answer);
    }

    public List<Answer> getAllAnswersByQuestion_id(Integer id) {
        Iterable<Integer> a = Collections.singleton(id);
        return answers.findAllById(a);
    }

    public void deleteAnswerById(Integer id) {
        answers.deleteById(id);
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
