package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.repository.AccountEntityRepository;
import cn.pzhu.spring.repository.UserEntityRepository;
import cn.pzhu.spring.service.EmailService;
import cn.pzhu.spring.web.response.ExceptionMsg;
import cn.pzhu.spring.web.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private AccountEntityRepository accountEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;
    @Autowired
    private String LOGIN_SESSION_KEY;
    @Value("${server.port}")
    private String serverPort;

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

    // Return registration form template
    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, UserEntity userEntity) {
        modelAndView.addObject("userEntity", userEntity);
        modelAndView.setViewName(VIEW_REGISTER);
        return modelAndView;
    }

    // Process form input data
    @PostMapping("/register")
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid UserEntity userEntity, BindingResult bindResult, HttpServletRequest httpServletRequest) {
        modelAndView.setViewName(VIEW_REGISTER);
        // Lookup userEntity in database by e-mail
        UserEntity userExists = userEntityRepository.findByEmail(userEntity.getEmail());
        AccountEntity accountExists = accountEntityRepository.findAccountEntitiesByAccountName(userEntity.getEmail());

        if (userExists != null || accountExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "哎呀！ 邮箱已存在，换个邮箱试试或者尝试登录");
            bindResult.reject("email");
        }

        if (!bindResult.hasErrors()) {
            // new userEntity so we create userEntity and send confirmation e-mail

            // Disable userEntity util they click on confirmation link in email
            AccountEntity emailAccountEntity = new AccountEntity();
            emailAccountEntity.setEnabled(false);
            emailAccountEntity.setUserEntityId(userEntity.getId());
            emailAccountEntity.setAccountName(userEntity.getEmail());
            emailAccountEntity.setConfirmationToken(UUID.randomUUID().toString());
            AccountEntity userNameAccountEntity = new AccountEntity();
            userNameAccountEntity.setEnabled(false);
            userNameAccountEntity.setUserEntityId(userEntity.getId());
            userNameAccountEntity.setAccountName(userEntity.getName());
            userNameAccountEntity.setConfirmationToken(UUID.randomUUID().toString());

            accountEntityRepository.save(emailAccountEntity);
            accountEntityRepository.save(userNameAccountEntity);

            String appUrl = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName();

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(userEntity.getEmail());
            registrationEmail.setSubject("注册确认");
            registrationEmail.setText("要确认您的电子邮件地址，请点击以下连接：\n"
                    + appUrl + ":" + serverPort + "/confirm?token=" + userEntity.getConfirmationToken());

            emailService.sendEmail(registrationEmail);

            modelAndView.addObject("confirmationMessage", "确认电子邮件已发送至" + userEntity.getEmail());
        }
        return modelAndView;
    }

    @PostMapping("/user/register")
    public Response create(UserEntity userEntity) {
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
            userEntity.setLastModifiedDate(new Date());
            userEntity.setProfilePicture("img/favicon.png");
            userEntityRepository.save(userEntity);

            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setAccountName(userEntity.getName());
            accountEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            accountEntity.setUserEntityId(userEntity.getId());
            accountEntityRepository.save(accountEntity);

            // 添加默认属性设置
//            configService.saveConfig(userEntity.getId(), String.valueOf(favorites.getId()));
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest()
                    .getSession()
                    .setAttribute(LOGIN_SESSION_KEY, userEntity);
        } catch (Exception e) {
            logger.error("create userEntity failed, ", e);
            return new Response(ExceptionMsg.FAILED);
        }
        return new Response();
    }
}
