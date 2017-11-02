package org.javacore.netty.nettyserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by ddfhznq on 2017/9/26.
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    protected EchoClientHandler() {
        super();
    }

    protected EchoClientHandler(boolean autoRelease) {
        super(autoRelease);
    }

    protected EchoClientHandler(Class<? extends ByteBuf> inboundMessageType) {
        super(inboundMessageType);
    }

    protected EchoClientHandler(Class<? extends ByteBuf> inboundMessageType, boolean autoRelease) {
        super(inboundMessageType, autoRelease);
    }

    @Override
    public boolean acceptInboundMessage(Object msg) throws Exception {
        return super.acceptInboundMessage(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {

    }
}
