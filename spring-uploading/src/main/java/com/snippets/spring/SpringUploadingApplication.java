package com.snippets.spring;

import com.snippets.spring.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringUploadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUploadingApplication.class, args);
    }
}
