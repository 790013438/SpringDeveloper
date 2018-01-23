package com.snippets.spring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class SpringBootSimpleApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
