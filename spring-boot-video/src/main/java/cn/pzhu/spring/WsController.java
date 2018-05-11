package cn.pzhu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.ByteBuffer;

@Controller
@ServerEndpoint(value = "/WScams")
public class WsController {

    @RequestMapping("/wsServer")
    public void OnOpen(Session session) {
        System.out.println(session.toString());
    }

    @OnMessage
    public void onMessage(Session session, byte[] img) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(img);
        try {
        session.getBasicRemote().sendBinary(byteBuffer);
        } catch(IOException e) {
            // TODO
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
