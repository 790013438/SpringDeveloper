package cn.pzhu.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SpringBootJmsV2Application {

    private static final Logger log = LoggerFactory.getLogger(SpringBootJmsV2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJmsV2Application.class, args);
    }

    @JmsListener(destination="${myqueue}")
    public void simplerConsumer(String message) {
        log.info("Simple Consumer> " + message);
    }

    @Value("${myqueue}")
    String queue;

    @Bean
    CommandLineRunner start(JmsTemplate jmsTemplate) {
        return args -> {
            log.info("Sending> ...");
            jmsTemplate.convertAndSend(queue, "SpringBoot Rocks!");
        };
    }
}
