package org.javacore.netty.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 *  netty服务端
 * Created by ddfhznq on 2017/9/26.
 */
public class EchoServer {

    private final int port;

    EchoServer(int port){
        this.port = port;
    }

    public void start() throws Exception {

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {


            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                .group(eventLoopGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(port)
                .childHandler(new ChannelInitializer<Channel>() {

                    @Override
                    public void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new EchoServerHandler());
                    }
                });

            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            System.out.print(EchoServer.class.getName()+"started and listen on "
            +channelFuture.channel().localAddress());
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdown();
        }
    }

    public static void main(String []args)throws Exception{
        new EchoServer(65535).start();
    }
}
