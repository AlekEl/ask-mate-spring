package com.codecool.askmate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/add-question")
    public String addQuestion(){
        return "addQuestionPage";
    }

    @PostMapping(value = "/save-question")
    public String saveQuestion(){
        return "redirect:/";
    }

    @RequestMapping(value = "/")
    public String showHomePage(){
        return "homePage";
    }
}
