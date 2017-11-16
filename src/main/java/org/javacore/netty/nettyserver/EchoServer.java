package org.javacore.netty.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.javacore.io.test.netty.ServerHandler;

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
                .handler(new SimpleServerHandler())
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ServerHandler());
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
    private static class SimpleServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelActive");
        }

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelRegistered");
        }

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            System.out.println("handlerAdded");
        }
    }


    public static void main(String []args)throws Exception{
        new EchoServer(8090).start();
    }
}
