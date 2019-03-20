package com.codecool.askmate.Controller;

import com.codecool.askmate.Model.AuditionModel;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

//    private AnswerService answerService;
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
//        this.answerService = answerService;
    }

    @PostMapping(value = "/questions")
    public void saveQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @GetMapping("/questions")
    public List<AuditionModel> showAllQuestion() {
        return questionService.getAllQuestions();
    }

    @GetMapping(value = "/search")
    public List<Question> searchWord(@RequestParam("word") String word) {
        return questionService.searchWord(word);
    }

    @GetMapping("/questions/{id}")
    public Question questionDetails(@PathVariable("id") Integer id) {
        return questionService.getQuestionByID(id);
    }

    @GetMapping("/deleteQuestion")
    public void deleteQuestion(@RequestParam int id) {
        questionService.deleteQuestionById(id);
    }

    @GetMapping("/editQuestion")
    public void editQuestion(@RequestParam("id") Integer id) {
        questionService.getQuestionByID(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/questions/{id}")
    public void editQuestionPut(@PathVariable Integer id, @RequestBody Question question) {
        questionService.editQuestion(id, question);
    }
}
