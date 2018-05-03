package cn.pzhu.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${mail.fromMail.address}")
    private String fromMail;

    @Async
    public void sendEmail(SimpleMailMessage simpleMailMessage) {
        simpleMailMessage.setFrom(fromMail);
        javaMailSender.send(simpleMailMessage);
    }
}
