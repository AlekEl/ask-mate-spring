package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class QuestionRepository {


    private Map<Integer, Question> questions = new HashMap<>();

    public QuestionRepository() {

        questions.put(generateId(), new Question("I have git problem", "Adam", "Git problem", generateId()));
        questions.put(generateId(), new Question("I have js problem", "Daniel", "JS problem", generateId()));
        questions.put(generateId(), new Question("I have java problem", "Maciek", "Java problem", generateId()));

    }

    public void addQuestion(Question question) {

    }

    public void removeQuestion(Integer questionID) {
        questions.remove(questionID);

    }

    public void editQuestion(Integer questionID) {

    }

    public Collection<Question> getAllQuestions() {
        return questions.values();
    }

    public Question getQuestionByID(Integer questionID) {
        return questions.get(questionID);
    }

    private int generateId() {
        int id = 1;

        if (questions != null) {
            for (Integer questionId : questions.keySet()) {
                if (questionId >= id) id = questionId + 1;
            }
        }
        return id;
    }
}
