package cn.pzhu.spring.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public Producer(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void sendTo(String topic, String message) {
        logger.info("Sending> ...");
        this.stringRedisTemplate.convertAndSend(topic, message);
    }
}
