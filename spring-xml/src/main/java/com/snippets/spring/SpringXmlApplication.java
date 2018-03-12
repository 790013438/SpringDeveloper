package com.snippets.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.snippets.spring.service.SimpleService;

@RestController
@ImportResource({"META-INF/spring/service-context.xml"})
@SpringBootApplication
public class SpringXmlApplication {

    private final SimpleService simpleService;


    @Autowired
    public SpringXmlApplication(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    @RequestMapping("/")
    public String index() {
        return simpleService.getHtmlH1From("Using Spring XML beans in here!");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringXmlApplication.class, args);
    }
}
