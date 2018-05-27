package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.domain.UserRoleEntity;
import cn.pzhu.spring.domain.enumerate.RoleEnum;
import cn.pzhu.spring.repository.AccountEntityRepository;
import cn.pzhu.spring.repository.UserEntityRepository;
import cn.pzhu.spring.repository.UserRoleEntityRepository;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private AccountEntityRepository accountEntityRepository;
    @Autowired
    private UserRoleEntityRepository userRoleEntityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;
    @Value("${server.port}")
    private String serverPort;

    private static final String VIEW_REGISTER = "register";
    private static final String VIEW_CONFIRM = "confirm";
    private static final String VIEW_FORGET_PASSWORD = "forgetPassword";
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/deleteUser")
    public ModelAndView delete(ModelAndView modelAndView,
                               @RequestParam(value = "id") String id) {
        modelAndView.setViewName("redirect:/admin");
        userEntityRepository.deleteById(id);
        return modelAndView;
    }


    @GetMapping("/forgetPassword")
    public ModelAndView forgetPassword(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_FORGET_PASSWORD);

        return modelAndView;
    }

    @PostMapping("/forgetPassword")
    public Response forgetPasswordMail(String email, HttpServletRequest httpServletRequest) {
        try {
            UserEntity userExits = userEntityRepository.findByEmail(email);
            if (null == userExits) {
                return new Response(ExceptionMsg.EmailNotRegister);
            }
            userExits.setConfirmationToken(UUID.randomUUID().toString());
            userExits.setOutDate(new Date(System.currentTimeMillis() + 1800000)); // 30分钟后过期
            userExits = userEntityRepository.save(userExits);

            String appUrl = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName();

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(userExits.getEmail());
            registrationEmail.setSubject("修改密码");
            registrationEmail.setText("请点击以下连接修改密码：\n"
                    + appUrl + ":" + serverPort + "/confirm?token=" + userExits.getConfirmationToken());

            emailService.sendEmail(registrationEmail);
        } catch (Exception e) {
            logger.error("sendForgotPasswordEmail failed, ", e);
            return new Response(ExceptionMsg.FAILED);
        }
        return new Response();
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
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid UserEntity userEntity,
                                                BindingResult bindResult, HttpServletRequest httpServletRequest) {
        modelAndView.setViewName(VIEW_REGISTER);
        // Lookup userEntity in database by e-mail
        UserEntity userExists = userEntityRepository.findByEmail(userEntity.getEmail());

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "哎呀！ 邮箱已存在，换个邮箱试试或者尝试登录");
            bindResult.reject("email");
        }
        //
        AccountEntity accountExists = accountEntityRepository.findAccountEntitiesByAccountName(userEntity.getName());

        if (accountExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "哎呀！ 用户名已存在，换个用户名试试或者尝试登录");
            bindResult.reject("userName");
        }

        if (!bindResult.hasErrors()) {
            // new userEntity so we create userEntity and send confirmation e-mail

            // Disable userEntity util they click on confirmation link in email
            userEntity.setConfirmationToken(UUID.randomUUID().toString());
            userEntity = userEntityRepository.save(userEntity);
            AccountEntity emailAccountEntity = new AccountEntity();
            emailAccountEntity.setEnabled(false);
            emailAccountEntity.setUserEntityId(userEntity.getId());
            emailAccountEntity.setAccountName(userEntity.getEmail());
            AccountEntity userNameAccountEntity = new AccountEntity();
            userNameAccountEntity.setEnabled(false);
            userNameAccountEntity.setUserEntityId(userEntity.getId());
            userNameAccountEntity.setAccountName(userEntity.getName());

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

    @GetMapping("/confirm")
    public ModelAndView confirm(ModelAndView modelAndView, @RequestParam("token") String token) {
        UserEntity userEntity = userEntityRepository.findByConfirmationToken(token);

        if (userEntity == null) {
            // No token found in DB
            modelAndView.addObject("invalidToken", "哎呀！ 这是一个无效的确认链接。");
        } else {
            // Token found
            modelAndView.addObject("confirmationToken", userEntity.getConfirmationToken());
        }

        modelAndView.setViewName(VIEW_CONFIRM);
        return modelAndView;
    }

    // Process confirmation link
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
        modelAndView.setViewName(VIEW_CONFIRM);

        // 找到与重置令牌关联的用户
        UserEntity userEntity = userEntityRepository.findByConfirmationToken(requestParams.get("token"));

        // 设置新密码, 将用户account设置为启用
        userEntity.setPassword(passwordEncoder.encode(requestParams.get("password")));
        List<AccountEntity> accountEntityList = accountEntityRepository.findByUserEntityId(userEntity.getId())
                .parallelStream()
                .peek(e -> {
                    e.setPassword(passwordEncoder
                            .encode(requestParams
                                    .get("password")));
                    e.setEnabled(true);
                }).collect(Collectors.toList());
        UserRoleEntity userRoleEntity = userRoleEntityRepository.findByUserEntityId(userEntity.getId());
        if (userRoleEntity == null) {
            userRoleEntity = new UserRoleEntity();
        }
        userRoleEntity.setRole(RoleEnum.STUDENT);
        userRoleEntity.setUserEntityId(userEntity.getId());

        // 保存用户> 账号
        try {
            userEntityRepository.save(userEntity);
            accountEntityRepository.saveAll(accountEntityList);
            userRoleEntityRepository.save(userRoleEntity);
        } finally {
            userEntity.setConfirmationToken("");
            userEntityRepository.save(userEntity);
        }

        modelAndView.addObject("successMessage", "您的密码设置成功！");
        return modelAndView;
    }
}
