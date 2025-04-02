package com.helium.SmartChargeStation.demo.netty.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 超时处理(服务端) 处理器
 */
public class ImoocServerHeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 因为userEventTriggered接收了IdleStateHandler传递过来的IdleStateEvent事件
        // 所以Object evt可以强制转换为IdleStateEvent事件

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()) {
                case READER_IDLE -> ctx.channel().close();
                case WRITER_IDLE, ALL_IDLE -> {}
            }
        }
    }
}
