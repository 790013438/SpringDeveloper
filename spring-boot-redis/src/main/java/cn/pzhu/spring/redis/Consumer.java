package cn.pzhu.spring.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public void messageHandler(String message) {
        logger.info("Consumer> " + message);
    }
}
