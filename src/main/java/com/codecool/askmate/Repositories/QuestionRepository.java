package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class QuestionRepository {


    Map<Integer, Question> questions = new HashMap<>();

    public QuestionRepository() {
        questions.put(1, new Question("I have git problem", "Adam", "Git problem",1));
        questions.put(2, new Question("I have js problem", "Daniel", "JS problem",2));
        questions.put(3, new Question("I have java problem", "Maciek", "Java problem",3));

    }

    public void addQuestion(Question question) {

    }

    public void removeQuestion(Integer questionID) {

    }

    public void editQuestion(Integer questionID) {

    }

    public Collection<Question> getAllQuestions() {
        return questions.values();
    }

    public Question getQuestionByID(Integer questionID) {
        return questions.get(questionID);
    }
}
