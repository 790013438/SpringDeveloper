package cn.pzhu.spring;

import cn.pzhu.spring.rabbitmq.Producer;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRabbitmqApplication {

    @Value("${myqueue}")
    String queueString;
    private final Producer producer;

    @Autowired
    public SpringBootRabbitmqApplication(Producer producer) {
        this.producer = producer;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue(queueString, false);
    }

    @Bean
    CommandLineRunner sender(Producer producer) {
        return args -> {
            producer.sendTo(queueString, "Hello World");
        };
    }
}
