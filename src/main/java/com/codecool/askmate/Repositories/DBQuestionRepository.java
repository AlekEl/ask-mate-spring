package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.RepositoriesInterface.QuestionRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


public class DBQuestionRepository implements QuestionRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addQuestion(Question question) {
        em.persist(question);
    }

    @Override
    @Transactional
    public void removeQuestion(Integer questionID) {
        Question question = em.find(Question.class, questionID);
        em.remove(question);
    }

    @Override
    @Transactional
    public void editQuestion(int questionID, Question question) {
        em.merge(question);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return em.createQuery("from Question ", Question.class).getResultList();
    }

    @Override
    public Question getQuestionByID(int questionID) {
        return em.find(Question.class, questionID);
    }
}
