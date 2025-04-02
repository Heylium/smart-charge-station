package com.helium.SmartChargeStation.demo.netty;

import com.helium.SmartChargeStation.demo.netty.handlers.ImoocServerHeartBeatHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Netty 服务端固定模板
 */
@Component
@Order(1)
@Slf4j
public class NettyServer {

    private NioEventLoopGroup boss;
    private NioEventLoopGroup worker;

    private Channel channel;


    /* **********************
     *
     * @Value不起作用：
     *
     * 1. 没有加上@Component
     * 2. 变量是static类型
     *
     * *********************/
    @Value("${Netty.server.port}")
    private int port;


    /**
     * Netty启动
     */
    public void start() {
        /* **********************
         *
         *
         * Netty 对于NIO(主从Reactor模型) 的深度封装
         *
         * 1. NioEventLoop : 网络指挥官
         * 2. Channel：快递小哥
         * 3. ChannelPipeline：工作流水线
         * 4. ChannelHandler: 流水线上员工
         * 5. ByteBuf：数据容器
         *
         * *********************/

        // 处理网络请求
        boss = new NioEventLoopGroup();
        // 处理网络IO
        worker = new NioEventLoopGroup();

        /* **********************
         *
         * Bootstrap中文名称是“引导”
         * ServerBootstrap对象起到的作用：
         * Netty整个程序的组件初始化，启动，服务器连接等等的一个引导作用，
         * ServerBootstrap相当于一条主线，把Netty的主要组件串联起来
         *
         *
         * *********************/

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap
                .group(boss, worker) // 配置NioEventLoop
                .channel(NioServerSocketChannel.class) // 配置Channel
                .childHandler(new ChannelInitializer<>() {
                    //Channel 初始化
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        /* **********************
                         *
                         * Channel初始化是伴随ChannelPipeline的初始化
                         *
                         * *********************/

                        // 取出ChannelPipeline
                        ChannelPipeline pipeline = channel.pipeline();

                        /* **********************
                         *
                         * 真正进行业务逻辑处理
                         *
                         * 对于处理入站事件，
                         * 处理器的执行顺序是按照添加到ChannelPipeline的顺序执行
                         *
                         * *********************/

                        ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                        pipeline
                                .addLast(new IdleStateHandler(60, 60, 60, TimeUnit.SECONDS))
                                .addLast(new ImoocServerHeartBeatHandler())
                                ;
                    }
                })
        ;
    }
}
