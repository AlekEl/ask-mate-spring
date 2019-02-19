package com.codecool.askmate.Controller;


import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
>>>>>>> e80a5056e0760e763e1af058176b09e45515b1aa

@Controller
public class HomeController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/add-question")
    public String addQuestion() {
        return "addQuestionPage";
    }

<<<<<<< HEAD
    @PostMapping(value = "/save-question")
    public String saveQuestion(){
        return "redirect:/";
    }

    @RequestMapping(value = "/")
    public String showHomePage(){
=======
    @RequestMapping("/")
    public String showHomePage(Model model) {
        Collection<Question> questions = questionService.getAllQuetions();
        model.addAttribute("questions", questions);
>>>>>>> e80a5056e0760e763e1af058176b09e45515b1aa
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
