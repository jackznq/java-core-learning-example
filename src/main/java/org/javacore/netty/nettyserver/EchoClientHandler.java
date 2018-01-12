package org.javacore.netty.nettyserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

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
        System.out.println(msg);
        return super.acceptInboundMessage(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("---客户端开始接收数据--->>服务器的数据为"+msg.toString());
        ctx.channel().writeAndFlush("lisi");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("Client received: " + ByteBufUtil.hexDump(byteBuf.readBytes(byteBuf.readableBytes())));

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channelActive..");
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8)); // 必须有flush
    }
}
