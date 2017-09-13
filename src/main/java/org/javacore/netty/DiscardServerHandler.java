package org.javacore.netty;

import io.netty.buffer.ByteBuf;

import io.netty.buffer.ChannelBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        ((ByteBuf) msg).readLong(); // (3)
//        ReferenceCountUtil.release(msg);
    }

    @Override
    public ChannelBuf newInboundBuffer(ChannelHandlerContext ctx) throws Exception {
        return null;
    }

    public DiscardServerHandler() {
        super();
    }

    @Override
    public void beforeAdd(ChannelHandlerContext ctx) throws Exception {
        super.beforeAdd(ctx);
    }

    @Override
    public void afterAdd(ChannelHandlerContext ctx) throws Exception {
        super.afterAdd(ctx);
    }

    @Override
    public void beforeRemove(ChannelHandlerContext ctx) throws Exception {
        super.beforeRemove(ctx);
    }

    @Override
    public void afterRemove(ChannelHandlerContext ctx) throws Exception {
        super.afterRemove(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void inboundBufferUpdated(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        cause.printStackTrace();
        ctx.close();
    }
}
