package com.codecool.askmate.Controller;


import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class HomeController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/add-question")
    public String addQuestion() {
        return "addQuestionPage";
    }

    @RequestMapping("/")
    public String showHomePage(Model model) {
        Collection<Question> questions = questionService.getAllQuetions();
        model.addAttribute("questions", questions);
        return "homePage";
    }

    @RequestMapping("/question")
    public String questionDetails(@RequestParam("id") Integer id, Model model) {
        Question question = questionService.getQuestionByID(id);
        model.addAttribute("question", question);
        return "question";

    }

    @RequestMapping("/deleteQuestion")
    public String deleteQuestion(@RequestParam Integer id) {
        questionService.deleteQuestionById(id);
        return "redirect:/";
    }
}
