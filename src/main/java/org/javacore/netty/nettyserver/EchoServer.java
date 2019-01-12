package org.javacore.netty.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.Arrays;

/**
 * netty服务端
 * Created by ddfhznq on 2017/9/26.
 */
public class EchoServer {

    private final int port;

    EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {

        //创建boss线程池，一般只传一个线程
        EventLoopGroup boss = new NioEventLoopGroup(1);
        //创建work线程
        EventLoopGroup work = new NioEventLoopGroup();
        try {

            //启动服务
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                .group(boss, work)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    public void initChannel(SocketChannel ch)  {
                        ch.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                        ch.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(4096,Delimiters.lineDelimiter()));
                        ch.pipeline().addLast(new EchoServerHandler());
                    }
                });
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoServer(8099).start();
    }

}
