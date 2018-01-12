package org.javacore.netty.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
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

        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup();
        try {


            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                .group(boss,work)
                .channel(NioServerSocketChannel.class)
//                .localAddress(port)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new EchoServerHandler());
                    }
                });

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
//            System.out.print(EchoServer.class.getName()+"started and listen on "
//            +channelFuture.channel().localAddress());
            channelFuture.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    public static void main(String []args)throws Exception{
        System.out.println(args.length);
        new EchoServer(8090).start();
    }
}
