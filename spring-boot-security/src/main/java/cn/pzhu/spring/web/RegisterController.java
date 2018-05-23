package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private static final String VIEW_REGISTER = "views/registerForm";
    private static final String VIEW_SUCCESS = "views/success";

    @Autowired
    private UserService userService;

    @GetMapping("register")
    public ModelAndView registerForm(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_REGISTER);

        modelAndView.addObject("userEntity", new UserEntity());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid UserEntity userEntity,
            BindingResult bindingResult,
            ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_REGISTER);

        if (bindingResult.hasErrors()) {
            return modelAndView;
        }

        if (userService.isUserPresent(userEntity.getEmail())) {
            modelAndView.addObject("exist", true);

            return modelAndView;
        }
        userService.createUser(userEntity);
        modelAndView.setViewName(VIEW_SUCCESS);

        return modelAndView;
    }
}
