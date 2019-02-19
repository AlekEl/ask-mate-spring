package com.codecool.askmate.Controller;

<<<<<<< HEAD
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 574d4a0bb0716687fed624e2aacd7e039a8fbd49
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class HomeController {
    @RequestMapping(value = "/add-question")
    public String addQuestion(){
        return "addQuestionPage";
    }

<<<<<<< HEAD
    @Autowired
    QuestionService questionService;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        Collection<Question> questions = questionService.getAllQuetions();
        model.addAttribute("questions", questions);
=======
    @RequestMapping(value = "/")
    public String showHomePage(){
>>>>>>> 574d4a0bb0716687fed624e2aacd7e039a8fbd49
        return "homePage";
    }

    @RequestMapping("/question")
    public String questionDetails(@RequestParam("id") Integer id, Model model) {
        Question question = questionService.getQuestionByID(id);
        model.addAttribute("question", question);
        return "question";

    }
}
