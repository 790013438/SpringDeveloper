package com.snippets.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootConfigApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootConfigApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootConfigApplication.class)
                .logStartupInfo(true)
                .run(args);
    }

    @Value("${server.ip}")
    private
    String serverIp;

    @Bean
    CommandLineRunner values() {
        return args -> logger.info(" > The Server IP is:" + serverIp);
    }
}
