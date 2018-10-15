package com.lq.code.WebSocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Created by qi_liang on 2018/6/13.
 */
public interface WebSorketHandler {

    void alfterConeectionEstablished(WebSocketSession session)throws Exception;

    void handlMessage(WebSocketSession session, WebSocketMessage message)throws Exception;

    void handlTransportError(WebSocketSession session, CloseStatus closeStatus)throws Exception;

    boolean supportsPartialMessages();

}
