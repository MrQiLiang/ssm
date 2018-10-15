package com.lq.code.WebSocket;

import org.springframework.web.socket.*;

/**
 * Created by qi_liang on 2018/6/13.
 */
public abstract class AbstraceWebSocketHandler implements WebSocketHandler {

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage){
            handleTextMessage(session, (TextMessage) message);
        }
        else if (message instanceof BinaryMessage){
            handleBinaryMessage(session, (BinaryMessage) message);
        }
        else if (message instanceof PongMessage){
            handlPongMessage(session, (PongMessage) message);
        } else {
            throw new IllegalStateException("Unexpected WebSocket message type"+message);
        }
    }

    protected void handleTextMessage(WebSocketSession session,TextMessage message)throws Exception{

    }

    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message)throws Exception{

    }
    protected void handlPongMessage(WebSocketSession session,PongMessage message)throws Exception{

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

    }


}
