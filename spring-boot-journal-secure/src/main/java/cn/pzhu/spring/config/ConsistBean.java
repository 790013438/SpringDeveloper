package cn.pzhu.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsistBean {

    @Bean
    public String LOGIN_SESSION_KEY() {
        return "Favorites_user";
    }
}
