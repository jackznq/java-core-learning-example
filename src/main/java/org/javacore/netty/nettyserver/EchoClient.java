package org.javacore.netty.nettyserver;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                        ch.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
                        ch.pipeline().addLast(new EchoClientHandler());

                    }
                });

            Channel channel = clientBootstrap.connect(host, port).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for (; ; ) {

                channel.writeAndFlush(br.read() + "\r\n");
            }
        } finally {
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String args[]) throws Exception {
        new EchoClient("localhost", 8099).start();
    }
}

