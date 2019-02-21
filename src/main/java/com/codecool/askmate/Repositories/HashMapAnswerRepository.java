package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Repositories.RepositoriesInterface.AnswerRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HashMapAnswerRepository implements AnswerRepository {

    private Map<Integer, Answer> answers = new HashMap<>();


    public HashMapAnswerRepository() {

        answers.put(generateId(), new Answer("test", "Marian", generateId(), 1));
        answers.put(generateId(), new Answer("dfdfd", "Zbychu", generateId(), 2));
        answers.put(generateId(), new Answer("sdsdsd", "Zosia", generateId(), 3));
    }

    @Override
    public void addAnswer(Answer answer) {
        Integer id = generateId();
        answer.setId(id);
        answers.put(id, answer);
    }

    @Override
    public void removeAnswer(Integer answerID) {
        answers.remove(answerID);
    }

    @Override
    public void editAnswer(Integer answerID, Answer answer) {
        answers.get(answerID).setText(answer.getText());
    }

    @Override
    public List<Answer> getAllAnswersByQuestionID(Integer questionID) {
        List<Answer> answerList = new ArrayList<>();
        for(Answer answer : answers.values()) {
            if(answer.getQuestionId().equals(questionID)) answerList.add(answer);
        }
        return answerList;
    }

    private Integer generateId() {
        Integer id = 1;
        if (answers != null) {
            for (Integer questionId : answers.keySet()) {
                if (questionId >= id) id = questionId + 1;
            }
        }
        return id;
    }
}
