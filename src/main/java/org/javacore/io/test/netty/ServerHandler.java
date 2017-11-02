package org.javacore.io.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.javacore.io.utils.Calculator;

import java.io.UnsupportedEncodingException;

/**
 * Handles a server-side channel.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {


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
        String calrResult = null;
        try {
            calrResult = Calculator.Instance.cal(body).toString();
        } catch (Exception e) {
            calrResult = "错误的表达式：" + e.getMessage();
        }
        ctx.write(Unpooled.copiedBuffer(calrResult.getBytes()));
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
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
