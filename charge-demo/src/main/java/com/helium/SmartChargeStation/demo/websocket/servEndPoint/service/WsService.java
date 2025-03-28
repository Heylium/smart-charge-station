package com.helium.SmartChargeStation.demo.websocket.servEndPoint.service;


import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * WebSocket(基于Tomcat @ServerEndPoint) 服务类
 */
@Component
@Slf4j
//========
//基于Tomcat @ServerEndPoint注解和基于Spring注解的WebSocket服务
//两者只能运行一个
//例如，要运行基于Tomcat @ServerEndPoint注解的WebSocket服务
//把 @ServerEndpoint 注解打开，
//并且要将 @EnableWebSocket 注解注释掉
//@EnableWebSocket在 com.imooc.SmartChargeStation.demo.WebSocketApplication
//=======
@ServerEndpoint("/ws/server")
public class WsService {
    /* **********************
     *
     * @ServerEndpoint修饰的类，
     * 包含@Open @Close @OnMessage @OnError方法
     *
     * 疑问？
     * Springboot如何能将@ServerEndpoint修饰的类
     * 注入到容器里？
     *
     * *********************/

    @OnOpen
    public void onOpen() {
        log.info(">>>> ServerEndPoint 连接建立成功！ <<<<");
    }

    @OnClose
    public void onClone() {

    }

    @OnMessage
    public void onMessage(String message) {

    }

    @OnError
    public void onError(Throwable error) {

    }
}
