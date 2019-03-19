package com.codecool.askmate.Controller;

import com.codecool.askmate.Model.AuditionModel;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String saveQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return "redirect:/";
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
    public String deleteQuestion(@RequestParam int id) {
        questionService.deleteQuestionById(id);
        return "redirect:/";
    }

    @GetMapping("/editQuestion")
    public String editQuestion(@RequestParam("id") Integer id) {
        questionService.getQuestionByID(id);
        return "redirect:/question?id=" + id;
    }

    @PutMapping("/editQuestion")
    public String editQuestionPut(@RequestParam Integer id, @RequestBody Question question) {
        questionService.editQuestion(id, question);
        return "redirect:/question?id=" + id;
    }
}
