package com.snippets.spring;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootSimpleApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder()
                .bannerMode(Banner.Mode.OFF)
                .sources(SpringBootSimpleApplication.class)
                .run(args);
    }
}
