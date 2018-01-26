package com.snippets.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class SpringBootSimpleApplication implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootSimpleApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootSimpleApplication.class)
                .logStartupInfo(false)
                .run(args);
    }

    @Bean
    String info() {
        return "Just a simple String bean";
    }

    @Autowired
    private String info;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        LOGGER.info("## > ApplicationRunner Implementation...");
        LOGGER.info("Accessing the Info bean: " + info);
        applicationArguments.getNonOptionArgs().forEach(LOGGER::info);
    }

    @Bean
    CommandLineRunner myMethod() {
        return args -> {
            LOGGER.info("## > CommandLineRunner Implementation...");
            LOGGER.info("Accessing the Info bean: " + info);
            for (String arg : args)
                LOGGER.info(arg);
        };
    }
}

@Component
class MyComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyComponent.class);

    @Autowired
    public MyComponent(ApplicationArguments applicationArguments) {
        boolean enable = applicationArguments.containsOption("enable");
        if (enable)
            LOGGER.info("## > You are enable!");

        List<String> _args = applicationArguments.getNonOptionArgs();
        LOGGER.info("## > extra args ...");
        if (!_args.isEmpty())
            _args.forEach(LOGGER::info);
    }
}
