package com.codecool.askmate.Controller;


import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Model.FormView;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.AnswerService;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class QuestionController {

    private AnswerService answerService;
    private QuestionService questionService;


    @Autowired
    public QuestionController(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @RequestMapping(value = "/add-question")
    public String addQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "addQuestionPage";
    }

    @PostMapping(value = "/add-question")
    public String saveQuestion(@ModelAttribute("question") Question question) {
        questionService.addQuestion(question);
        return "redirect:/";
    }

    @RequestMapping("/")
    public String showAllQuestion(Model model) {
        Collection<Question> questions = questionService.getAllQuetions();
        model.addAttribute("questions", questions);
        model.addAttribute("word", new FormView());
        return "homePage";
    }

    @PostMapping(value = "/search")
    public String searchWord(@ModelAttribute("word") FormView searchWord, Model model) {
        List<Question> searchQuestion = questionService.searchWord(searchWord.getText());
        model.addAttribute("searchQuestions", searchQuestion);
        model.addAttribute("searchWord", searchWord);
        return "searchQuestions";
    }

    @RequestMapping("/question")
    public String questionDetails(@RequestParam("id") Integer id, Model model) {
        Question question = questionService.getQuestionByID(id);
        List<Answer> answers= answerService.getAllAnswersByQuestionID(id);
        model.addAttribute("question", question);
        model.addAttribute("answers",answers);
        return "question";
    }

    @RequestMapping("/deleteQuestion")
    public String deleteQuestion(@RequestParam Integer id) {
        questionService.deleteQuestionById(id);
        return "redirect:/";
    }

    @RequestMapping("/editQuestion")
    public String editQuestion(@RequestParam("id") Integer id, Model model) {
        Question question = questionService.getQuestionByID(id);
        model.addAttribute("question", question);
        return "editQuestion";
    }

    @RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
    public String editQuestionPUT(@RequestParam("id") Integer id, @ModelAttribute("question") Question question) {
        questionService.editQuestion(id, question);
        return "redirect:/";
    }
}
