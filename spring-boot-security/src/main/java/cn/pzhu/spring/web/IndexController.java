package cn.pzhu.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("paragraph")
    public String paragraph() {
        return "fragments/paragraph";
    }
}