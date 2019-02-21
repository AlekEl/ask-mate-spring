package com.codecool.askmate.Controller;

import com.codecool.askmate.Model.Answer;
import com.codecool.askmate.Model.Question;
import com.codecool.askmate.Services.AnswerService;
import com.codecool.askmate.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnswerController {

   private AnswerService answerService;
   private QuestionService questionService;

    @Autowired
    public AnswerController(AnswerService answerService,QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @RequestMapping("/deleteAnswer")
    public String deleteAnswer(@RequestParam("id") Integer id,@RequestParam("questionId") Integer questionId){
        answerService.deleteAnswerById(id);
        return "redirect:/question?id=" + questionId;
    }

    @RequestMapping("/editAnswer")
    public String editAnswer(@RequestParam("id") Integer id, Model model){
        Answer answer = answerService.getAnswerById(id);
        model.addAttribute("answer", answer);
        return "editAnswer";
    }

    @RequestMapping(value = "/editAnswer",method = RequestMethod.POST)
    public String editAnswer(@RequestParam("id") Integer id, @RequestParam("questionId") Integer questionId, @ModelAttribute Answer answer){
        answerService.editAnswer(id, answer);
        System.out.println(id);
        return "redirect:/question?id=" + questionId;
    }

    @RequestMapping("/addAnswer")
    public String addAnswer(Model model, @RequestParam("id") Integer id){
        model.addAttribute("question", questionService.getQuestionByID(id));
        model.addAttribute("answer", new Answer());
        return "addAnswer";
    }

    @RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
    public String addAnswer(@ModelAttribute("answer") Answer answer, @RequestParam("id") Integer id){
        answerService.addAnswer(answer,id);
        return "redirect:/question?id=" + id;

    }


}
