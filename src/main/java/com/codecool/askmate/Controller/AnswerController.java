package com.codecool.askmate.Controller;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Model.AuditionModel;
import com.codecool.askmate.Services.AnswerService;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    private AnswerService answerService;
    private QuestionService questionService;

    @Autowired
    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @GetMapping("/deleteAnswer")
    public void deleteAnswer(@RequestParam("id") Integer id) {
        answerService.deleteAnswerById(id);
    }

    @PostMapping("/editAnswer")
    public void getAnswerToEdit(@RequestParam("id") Integer answerId) {
        AuditionModel result = answerService.getAnswerById(answerId);
        System.out.println(result.toString());
    }

    @PutMapping("/editAnswer")
    public void saveAnswer(@RequestParam("id") Integer answerId, @RequestBody Answer answer) {
        answerService.editAnswer(answerId, answer);
    }

    @RequestMapping("/addAnswer")
    public void addAnswer(@RequestBody Answer answer, @RequestParam("questionId") Integer questionId) {
        answerService.addAnswer(answer, questionId);
    }
}
