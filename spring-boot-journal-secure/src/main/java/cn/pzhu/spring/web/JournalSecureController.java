package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.JournalEntryEntity;
import cn.pzhu.spring.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JournalSecureController {

    private static final String VIEW_INDEX = "home";
    private static final String VIEW_LOGIN = "login";
    private final JournalRepository repo;

    @Autowired
    public JournalSecureController(JournalRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "10") Integer size) {
        modelAndView.setViewName(VIEW_INDEX);
        modelAndView.addObject("app", repo.findAll(PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "id"))));
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView indexContent(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("journal", repo.findAll());
        return modelAndView;
    }
}
