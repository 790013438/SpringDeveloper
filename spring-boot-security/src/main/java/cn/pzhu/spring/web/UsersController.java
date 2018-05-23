package cn.pzhu.spring;

import cn.pzhu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    private final static String VIEW_USERS = "views/list";

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public ModelAndView listUsers(ModelAndView modelAndView,
        @RequestParam(value="name", defaultValue="") String name) {
        modelAndView.setViewName(VIEW_USERS);

        modelAndView.addObject("users", userService.findByNameContains(name));
        return modelAndView;
    }
}
