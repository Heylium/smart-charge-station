package com.helium.SmartChargeStation.demo.websocket.spring.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
@Slf4j
public class ImoocHandler implements WebSocketHandler {

    /**
     * 握手之后触发
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(">>>>> 基于Spring注解 连接建立成功 <<<<<");
    }

    /**
     * 消息业务逻辑处理
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String payload = message.getPayload().toString();
        Object token = session.getAttributes().get("Token");
    }

    /**
     * 发送错误触发
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    /**
     * 连接断开触发
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

    }

    /**
     * 是否支持内容切片处理
     * @return boolean
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
