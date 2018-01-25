package com.snippets.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class SpringBootSimpleApplication {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
        new SpringApplicationBuilder(SpringBootSimpleApplication.class)
                .listeners((ApplicationListener<ApplicationEvent>) event -> log.info("#### > " + event.getClass().getCanonicalName()))
                .run(args);
    }
}
