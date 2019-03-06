package com.codecool.askmate.Repositories;

import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Repositories.RepositoriesInterface.QuestionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class DBQuestionRepository implements QuestionRepository, JpaRepository<Question,Integer> {

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
    public Question getQuestionByID(Integer questionID) {
        return em.find(Question.class, questionID);
    }





    @Override
    public List<Question> findAll() {
        return (List<Question>)getAllQuestions();
    }

    @Override
    public List<Question> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Question> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer aLong) {
        removeQuestion(aLong);

    }

    @Override
    public void delete(Question question) {

    }

    @Override
    public void deleteAll(Iterable<? extends Question> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Question> S save(S s) {
        addQuestion(s);
        return null;
    }

    @Override
    public <S extends Question> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Question> findById(Integer aLong) {
        return Optional.ofNullable(getQuestionByID(aLong));
    }

    @Override
    public boolean existsById(Integer aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Question> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Question> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Question getOne(Integer aLong) {
        return getQuestionByID(aLong);
    }

    @Override
    public <S extends Question> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Question> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Question> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Question> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Question> boolean exists(Example<S> example) {
        return false;
    }
}
