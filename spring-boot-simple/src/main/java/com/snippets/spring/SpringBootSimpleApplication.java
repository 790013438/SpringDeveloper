package com.snippets.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class SpringBootSimpleApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootSimpleApplication.class)
                .logStartupInfo(false)
                .run(args);
    }

}

@Component
class MyComponent {
    private static final Logger log = LoggerFactory.getLogger(MyComponent.class);

    @Autowired
    public MyComponent(ApplicationArguments applicationArguments) {
        boolean enable = applicationArguments.containsOption("enable");
        if (enable)
            log.info("## > You are enable!");

        List<String> _args = applicationArguments.getNonOptionArgs();
        log.info("## > extra args ...");
        if (!_args.isEmpty())
            _args.forEach(log::info);
    }
}
