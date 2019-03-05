package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.RepositoriesInterface.QuestionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


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
