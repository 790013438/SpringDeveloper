package com.snippets.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootSimpleApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(SpringBootSimpleApplication.class)
                .profiles("prod", "cloud")
                .run(args);
    }
}
