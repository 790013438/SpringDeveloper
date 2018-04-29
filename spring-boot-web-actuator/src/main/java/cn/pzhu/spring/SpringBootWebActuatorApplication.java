package cn.pzhu.spring;

import cn.pzhu.spring.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootWebActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebActuatorApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "Spring Boot Actuator";
    }

    private static final Logger logger = LoggerFactory.getLogger(SpringBootWebActuatorApplication.class);

    @Bean
    CommandLineRunner findAll(PersonRepository personRepository) {
        return args -> {
            logger.info("> Persons in Database: ");
            personRepository
                    .findAll()
                    .forEach(person -> logger.info(person.toString()));
        };
    }
}
