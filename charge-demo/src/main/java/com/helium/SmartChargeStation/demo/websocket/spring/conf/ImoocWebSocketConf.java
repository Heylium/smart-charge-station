package com.helium.SmartChargeStation.demo.websocket.spring.conf;

import com.helium.SmartChargeStation.demo.websocket.spring.handler.ImoocHandler;
import com.helium.SmartChargeStation.demo.websocket.spring.interceptor.ImoocInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * WebSocket(基于Spring注解) 配置类
 */
@Configuration
public class ImoocWebSocketConf implements WebSocketConfigurer {

    @Resource
    private ImoocInterceptor interceptor;

    @Resource
    private ImoocHandler handler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        /* **********************
         *
         * 处理器：WebSocket握手之后触发
         *
         * 拦截器：WebSocket握手之后，以及握手之前都可以触发
         *
         * *********************/
        registry
                .addHandler(handler, "/ws/server")
                .addInterceptors(interceptor)
                .setAllowedOrigins("*");
    }
}
