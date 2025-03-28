package com.helium.SmartChargeStation.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * WebSocket 启动类
 */

//========
//基于Tomcat @ServerEndPoint注解和基于Spring注解的WebSocket服务
//两者只能运行一个
//例如，要运行基于Spring注解的WebSocket服务
//把 @EnableWebSocket 注解打开，
//并且要将@ServerEndPoint注解注释掉
//@ServerEndPoint在 com.imooc.SmartChargeStation.demo.websocket.servEndPoint.service.WsService
//=======

//启动Spring封装注解的WebSocket
//@EnableWebSocket
@EnableWebSocket
@SpringBootApplication
public class WebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }
}
