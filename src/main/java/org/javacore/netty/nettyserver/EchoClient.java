package org.javacore.netty.nettyserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by ddfhznq on 2017/9/26.
 */
public class EchoClient {

    private final String host;

    private final int port;

    EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {


            Bootstrap clientBootstrap = new Bootstrap();
            clientBootstrap
                .group(eventLoopGroup)
                .channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host, port))
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new EchoClientHandler());
                    }
                });

            System.out.println("created..");
            ChannelFuture channelFuture = clientBootstrap.connect().sync();
            System.out.println("connected..."); // 连接完成
            channelFuture.channel().closeFuture().sync();
            System.out.println("closed.."); // 关闭完成
        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String args[]) throws Exception {
        new  EchoClient("localhost",8001).start();
    }
}

