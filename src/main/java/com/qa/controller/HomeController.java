package com.qa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value={"/home.html","/"}, method=RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @RequestMapping("/welcome.html")
    public ModelAndView welcome(){
        return new ModelAndView("welcome");
    }

    @RequestMapping("/question-list.html")
    public ModelAndView questionList(){
        return new ModelAndView("question-list");
    }
}
