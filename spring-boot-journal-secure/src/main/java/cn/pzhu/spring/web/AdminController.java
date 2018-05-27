package cn.pzhu.spring.web;

import cn.pzhu.spring.repository.CommentEntityRepository;
import cn.pzhu.spring.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private static final String VIEW_USERS = "admin";
    private static final String VIEW_COMMENTS_ADMIN = "commentsAdmin";
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private CommentEntityRepository commentEntityRepository;
    @Autowired
    private Sort displayASCSort;

    @GetMapping("/admin")
    public ModelAndView user(ModelAndView modelAndView,
                             @RequestParam(defaultValue = "0", value = "page") Integer page,
                             @RequestParam(defaultValue = "6", value = "size") Integer size) {
        modelAndView.setViewName(VIEW_USERS);
        modelAndView.addObject("title", "管理中心");
        modelAndView.addObject("active", "home");

        modelAndView.addObject("users",
                userEntityRepository.findAll(PageRequest.of(page, size, displayASCSort)));

        return modelAndView;
    }

    @GetMapping("/admin/comments")
    public ModelAndView comments(ModelAndView modelAndView,
                                 @RequestParam(value="page", defaultValue = "0") Integer page,
                                 @RequestParam(value="size", defaultValue = "6") Integer size) {
        modelAndView.setViewName(VIEW_COMMENTS_ADMIN);
        Sort sort = Sort.by(Sort.Order.desc("createdDate"));
        modelAndView.addObject("data",
                commentEntityRepository.findAll(PageRequest.of(page, size, sort)));
        return modelAndView;
    }
}
