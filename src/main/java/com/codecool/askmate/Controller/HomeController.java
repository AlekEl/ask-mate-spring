package com.codecool.askmate.Controller;

import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("/")
    public String showHomePage(Model model){
        model.addAttribute("questions", questionService.getAllQuetions());
        return "homePage";
    }
}
