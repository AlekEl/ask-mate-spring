//package com.codecool.askmate.Repositories;
//
//import com.codecool.askmate.Model.Question;
//import com.codecool.askmate.Repositories.RepositoriesInterface.QuestionRepository;
//
//import java.util.*;
//
//
//public class HashMapQuestionRepository implements QuestionRepository {
//
//    private Map<Integer, Question> questions = new HashMap<>();
//
//    public HashMapQuestionRepository() {
//        questions.put(generateId(), new Question("I have git problem", "Adam", "Git problem", generateId()));
//        questions.put(generateId(), new Question("I have js problem", "Daniel", "JS problem", generateId()));
//        questions.put(generateId(), new Question("I have java problem", "Maciek", "Java problem", generateId()));
//    }
//
//    @Override
//    public void addQuestion(Question question) {
//        Integer id = generateId();
//        question.setQid(id);
//        questions.put(id, question);
//    }
//
//    @Override
//    public void removeQuestion(Integer questionID) {
//        questions.remove(questionID);
//    }
//
//    @Override
//    public void editQuestion(int questionID, Question question) {
//        questions.get(questionID).setDescription(question.getDescription());
//        questions.get(questionID).setShortDescription(question.getShortDescription());
//    }
//
//    @Override
//    public Collection<Question> getAllQuestions() {
//        return questions.values();
//    }
//
//
//    @Override
//    public Question getQuestionByID(Integer questionID) {
//        return questions.get(questionID);
//    }
//
//    private Integer generateId() {
//        Integer id = 1;
//        if (questions != null) {
//            for (Integer questionId : questions.keySet()) {
//                if (questionId >= id) id = questionId + 1;
//            }
//        }
//        return id;
//    }
//
//}
