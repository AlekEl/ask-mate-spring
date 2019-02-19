package com.codecool.askmate.Controller;


import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;

@Controller
public class HomeController {

    private final
    QuestionService questionService;

    @Autowired
    public HomeController(QuestionService questionService) {
        this.questionService = questionService;
    }

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

    @RequestMapping("/editQuestion")
    public String editQuestion(@RequestParam("id") Integer id, Model model) {
        System.out.println(id);
        Question question = questionService.getQuestionByID(id);
        model.addAttribute("question", question);
        return "editQuestion";
    }

    @RequestMapping(value="/editQuestion", method = RequestMethod.POST)
    public String editQuestionPUT(@Valid @RequestParam("id") Integer id, @ModelAttribute("question")Question question,
                                  BindingResult result, ModelMap model) {
        System.out.println(id);
        if(result.hasErrors()) {
            return "error";
        }

        return "redirect:/";
    }
}
