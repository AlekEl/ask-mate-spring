package com.codecool.askmate.Controller;

import com.codecool.askmate.Model.AuditionModel;
import com.codecool.askmate.Model.FormView;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.AnswerService;
import com.codecool.askmate.Services.QuestionService;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class QuestionController {

//    private AnswerService answerService;
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
//        this.answerService = answerService;
    }

    @PostMapping(value = "/add-question")
    public void saveQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @GetMapping("/")
    public List<AuditionModel> showAllQuestion() {
        return questionService.getAllQuestions();
    }

    @GetMapping(value = "/search")
    public List<Question> searchWord(@RequestParam("word") String word) {
        return questionService.searchWord(word);
    }

    @GetMapping("/question")
    public Question questionDetails(@RequestParam("id") Integer id) {
        return questionService.getQuestionByID(id);
    }

    @GetMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam int id) {
        questionService.deleteQuestionById(id);
    }

    //TO DO
    @GetMapping("/editQuestion")
    public Question editQuestion(@RequestParam("id") Integer id) {
        return questionService.getQuestionByID(id);
    }

    @PutMapping("/editQuestion")
    public void editQuestionPut(@RequestParam Integer id, @RequestBody Question question) {
        System.out.println(question);
        questionService.editQuestion(id, question);
    }
}
