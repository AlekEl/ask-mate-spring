package com.codecool.askmate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/add-question")
    public String addQuestion(){
        return "addQuestionPage";
    }

    @RequestMapping(value = "/")
    public String showHomePage(){
        return "homePage";
    }
}
