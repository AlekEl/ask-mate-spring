package com.codecool.askmate.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.codecool.askmate.Model.AuditionModel;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
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
    public HttpEntity<Question> questionDetails(@PathVariable("id") Integer id) {
        Question question = questionService.getQuestionByID(id);
        question.add(linkTo(methodOn(QuestionController.class).questionDetails(id)).withSelfRel());
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteQuestionById(id);
    }

    @GetMapping("/editQuestion")
    public void editQuestion(@RequestParam("id") Integer id) {
        questionService.getQuestionByID(id);
    }

    @PutMapping("/questions/{id}")
    public void editQuestionPut(@PathVariable Integer id, @RequestBody Question question) {
        questionService.editQuestion(id, question);
    }
}
