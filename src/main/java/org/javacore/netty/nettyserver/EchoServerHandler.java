package org.javacore.netty.nettyserver;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by ddfhznq on 2017/9/26.
 */
public class EchoServerHandler extends SimpleChannelInboundHandler<String> {


    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 收到客户端请求后，业务逻辑在这边处理
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        for (Channel ch : channels) {
            if (channel != ch) {
                ch.writeAndFlush(channel.remoteAddress() + "发消息" + msg + "\n");
            } else {
                ch.writeAndFlush("【自己】" + msg + "\n");
            }
        }
//        channels.forEach(ch -> {
//            if (channel != ch) {
//                ch.writeAndFlush(channel.remoteAddress() + "发消息" + msg + "\n");
//            } else {
//                ch.writeAndFlush("【自己】" + msg + "\n");
//            }
//        });
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "下线");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        Channel channel = ctx.channel();
        channels.writeAndFlush("服务器 -" + channel.remoteAddress() + "加入\n");
        channels.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush(channel.remoteAddress() + "离开\n");
        channels.remove(channel);
        System.out.println(channels.size());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "上线\n");
    }


}
