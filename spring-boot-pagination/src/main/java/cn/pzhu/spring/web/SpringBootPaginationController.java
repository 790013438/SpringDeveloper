package cn.pzhu.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SpringBootPaginationController {

    private static final String VIEW_INDEX = "index";

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession,
                              @RequestParam(value = "page", required = false, defaultValue = "0")Integer page) {

        modelAndView.setViewName(VIEW_INDEX);
        return modelAndView;
    }
}
