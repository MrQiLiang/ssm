package com.lq.code.WebSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;


/**
 * Created by qi_liang on 2018/4/18.
 */
public class MarcoHandler extends AbstractWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(MarcoHandler.class);
    //文本消息　
    protected void handleTextMessage(WebSocketSession session, TextMessage message)throws Exception{
        logger.info("Received message:"+message.getPayload());
     //   Thread.sleep(2000);   //  模拟延时
        session.sendMessage(new TextMessage("Polo!")); //发送小
    }

}
