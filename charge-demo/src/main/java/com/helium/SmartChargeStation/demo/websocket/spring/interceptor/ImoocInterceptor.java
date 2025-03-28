package com.helium.SmartChargeStation.demo.websocket.spring.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * 自定义拦截器
 */

@Component
@Slf4j
public class ImoocInterceptor implements HandshakeInterceptor {

    /**
     * 握手之前触发
     * @param request:
     * @param response:
     * @param wsHandler:
     * @param attributes:
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info(">>>>> 前置拦截 <<<<<");
        return true;
    }


    /**
     * 握手之后触发
     * @param request -
     * @param response -
     * @param handler -
     * @param ex
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Exception ex) {
        log.info(">>>>> 后置拦截 <<<<<");
    }
}
