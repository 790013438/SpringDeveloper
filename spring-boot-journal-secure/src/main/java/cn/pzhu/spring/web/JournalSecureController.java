package cn.pzhu.spring.web;

import cn.pzhu.spring.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JournalSecureController {

    private static final String VIEW_INDEX = "index";
    private static final String VIEW_LOGIN = "login";
    private final JournalRepository repo;

    @Autowired
    public JournalSecureController(JournalRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_INDEX);
        modelAndView.addObject("journal", repo.findAll());
        return modelAndView;
    }

    @RequestMapping(value="/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }

    @GetMapping("/index")
    public String indexContent() {
        return "index";
    }
}
