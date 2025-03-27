package com.helium.SmartChargeStation.demo.websocket.servEndPoint.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 配置ServerEndpointExporter
 */
@Configuration
public class ServerEndPointExp {

    /* **********************
     *
     * 需要声明一个ServerEndPointExporter Bean，
     * ServerEndPointExporter对象能将
     * @ServerEndPoint修饰的类注入到Spring容器里,
     * 如果不这样子做，@ServerEndPoint启动的WebSocket服务，
     * 客户端无法连接到WebSocket服务器
     *
     * 注意
     * 这样子的做法是针对SpringBoot框架
     * 若非SpringBoot框架，可忽略
     *
     * *********************/
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
