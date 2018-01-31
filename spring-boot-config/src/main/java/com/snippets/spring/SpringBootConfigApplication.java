package com.snippets.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootConfigApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootConfigApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootConfigApplication.class)
                .logStartupInfo(false)
                .run(args);
    }

    @Value("${myapp.server-ip}")
    private String serverIp;

    @Autowired
    private MyAppProperties myAppProperties;

    @Bean
    CommandLineRunner values() {
        return args -> {
            logger.info(" > The Server IP is:" + serverIp);
            logger.info(" > App Name: " + myAppProperties.getName());
            logger.info(" > App Info: " + myAppProperties.getDescription());
        };
    }

    @Component
    @ConfigurationProperties(prefix = "myapp")
    private static class MyAppProperties {
        private String name;
        private String description;
        private String serverIP;

        String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getServerIP() {
            return serverIP;
        }

        public void setServerIP(String serverIP) {
            this.serverIP = serverIP;
        }
    }
}
