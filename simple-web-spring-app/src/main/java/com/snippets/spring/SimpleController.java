package com.snippets.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/showMessage.html")
public class SimpleController {

    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal() {

        ModelAndView modelAndView = new ModelAndView("showMessage");
        modelAndView.addObject("message", "Spring MVC Web Application");

        return modelAndView;
    }
}
