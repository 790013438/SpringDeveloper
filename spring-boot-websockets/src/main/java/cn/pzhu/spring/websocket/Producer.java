package cn.pzhu.spring.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Producer {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void sendMessageTo(String topic, String message) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append("] ");
        stringBuilder.append(message);

        this.simpMessagingTemplate.convertAndSend("/topic/" + topic, stringBuilder.toString());
    }
}
