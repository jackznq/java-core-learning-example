package org.javacore.netty.nettyserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 *  简单的netty服务启动
 * Created by ddfhznq on 2017/11/16.
 */
public class MyNettyServer {

    private int port;

    private String host;
    public MyNettyServer(int port,String host){
        this.port = port;
        this.host = host;
    }
    public void start() throws Exception{
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap =new ServerBootstrap();
            serverBootstrap
                .group(boss,work)
                .channel(NioServerSocketChannel.class)
                .handler(new  MyHandler())
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new EchoServerHandler());
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });
            ChannelFuture cf = serverBootstrap.bind(port).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }


    private static class  MyHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelRegistered");
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelActive");
        }

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            System.out.println("handlerAdded");
        }
    }

    public static void main(String[] args)throws Exception {
        new MyNettyServer(8001,"localhost").start();
    }
}
