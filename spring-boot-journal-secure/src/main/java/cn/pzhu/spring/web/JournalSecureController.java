package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.repository.AccountEntityRepository;
import cn.pzhu.spring.repository.JournalRepository;
import cn.pzhu.spring.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private static final String VIEW_POWER_POINT = "file";

    private final JournalRepository repo;
    private final UserEntityRepository userEntityRepository;
    @Autowired
    private AccountEntityRepository accountEntityRepository;

    @Autowired
    public JournalSecureController(JournalRepository repo, UserEntityRepository userEntityRepository) {
        this.repo = repo;
        this.userEntityRepository = userEntityRepository;
    }

    @RequestMapping(value = {"/app", "/"}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView,
                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "6") Integer size) {
        modelAndView.setViewName(VIEW_INDEX);

        // 获取当前用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        AccountEntity accountEntity = accountEntityRepository.findAccountEntitiesByAccountName(name);

        modelAndView.addObject("apps", userEntityRepository.getApp(accountEntity.getUserRole(), PageRequest.of(page, size, new Sort(Sort.Direction.ASC, "id"))));
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

    /**
     * 课件，作业
     */
    @GetMapping("/file")
    public ModelAndView file(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_POWER_POINT);
        return modelAndView;
    }
}
