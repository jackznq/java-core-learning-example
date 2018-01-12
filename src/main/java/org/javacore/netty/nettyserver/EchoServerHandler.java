package org.javacore.netty.nettyserver;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;

/**
 * Created by ddfhznq on 2017/9/26.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 收到客户端消息
     *
     * @throws UnsupportedEncodingException
     */
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        ByteBuf in = (ByteBuf) msg;
        byte[] req = new byte[in.readableBytes()];
        in.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("收到客户端消息:" + body);
//        String calrResult = null;
        try {
            ctx.channel().writeAndFlush("zhangsan");
//            calrResult = Calculator.Instance.cal(body).toString();
        } catch (Exception e) {
        }
//        ctx.write(Unpooled.copiedBuffer(calrResult.getBytes()));
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(ctx);
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}
