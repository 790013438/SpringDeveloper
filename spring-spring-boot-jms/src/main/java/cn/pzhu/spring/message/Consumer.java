package cn.pzhu.spring.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${myqueue}", containerFactory = "myJmsListenerContainerFactory")
    public void onMessage(String message) {
        logger.info("Consumer> " + message);
    }
}
