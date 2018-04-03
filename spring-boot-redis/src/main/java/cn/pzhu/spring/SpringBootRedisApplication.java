package cn.pzhu.spring;

import cn.pzhu.spring.redis.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

    @Value("${topic}")
    private String topic;

    @Bean
    CommandLineRunner sendMessage(Producer producer) {
        return args -> {
            producer.sendTo(topic, "Spring Boot rocks Redis messaging!");
        };
    }
}
