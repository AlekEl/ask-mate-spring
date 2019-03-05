package com.codecool.askmate.Services;

import com.codecool.askmate.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class QuestionService {

    //    private QuestionRepository questionRepository;
    private JpaRepository dbposgres;

    @Autowired
    public QuestionService(JpaRepository dbposgres) {
        this.dbposgres = dbposgres;
    }

    @Transactional
    public void addQuestion(Question question) {
        dbposgres.save(question);
//        questionRepository.addQuestion(question);
    }

    public Collection<Question> getAllQuetions() {
//        return questionRepository.getAllQuestions();
        return dbposgres.findAll();
    }

    public Question getQuestionByID(Integer id) {
//        return questionRepository.getQuestionByID(id);

        return (Question) dbposgres.findById(id).orElse(null);
    }

    public void deleteQuestionById(int id) {
//        questionRepository.removeQuestion(id);
        dbposgres.deleteById(id);
    }

    public void editQuestion(Integer id, Question question) {
//        questionRepository.editQuestion(id, question);
        Question questionToUpdate = (Question)dbposgres.getOne(id);
        questionToUpdate.setDescription(question.getDescription());
        questionToUpdate.setShortDescription(question.getShortDescription());
        dbposgres.save(questionToUpdate);
    }

    public List<Question> searchWord(String word) {
        List<Question> searchWords = new ArrayList<>();
        List<Question> questionsList = dbposgres.findAll();
        for (Question question : questionsList) {
            if (question.getDescription().contains(word) || question.getShortDescription().contains(word)) {
                searchWords.add(question);
            }
        }
        return searchWords;
    }
}
