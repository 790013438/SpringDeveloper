package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.repository.UserEntityRepository;
import cn.pzhu.spring.web.response.ExceptionMsg;
import cn.pzhu.spring.web.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private String LOGIN_SESSION_KEY;

    private static final String VIEW_REGISTER = "register";
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping("/login")
    public Response login() {
        return new Response(ExceptionMsg.EmailUsed);
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_REGISTER);
        return modelAndView;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public Response create(@RequestBody UserEntity userEntity) {
        try {
            UserEntity registerUser = userEntityRepository.findByEmail(userEntity.getEmail());
            if (null != registerUser) {
                return new Response(ExceptionMsg.EmailUsed);
            }
            UserEntity userNameUser = userEntityRepository.findByName(userEntity.getName());
            if (null != userNameUser) {
                return new Response(ExceptionMsg.UserNameUsed);
            }
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userEntity.setLastModifyTime(new Date());
            userEntity.setProfilePicture("img/favicon.png");
            userEntityRepository.save(userEntity);


            // 添加默认属性设置
//            configService.saveConfig(user.getId(), String.valueOf(favorites.getId()));
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest()
                    .getSession()
                    .setAttribute(LOGIN_SESSION_KEY, userEntity);
        } catch (Exception e) {
            logger.error("create user failed, ", e);
            return new Response(ExceptionMsg.FAILED);
        }
        return new Response();
    }
}
