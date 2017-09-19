package org.javacore.io.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ChannelBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public ChannelBuf newInboundBuffer(ChannelHandlerContext ctx) throws Exception {
        return null;
    }

    public ClientHandler() {
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
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void inboundBufferUpdated(ChannelHandlerContext ctx) throws Exception {

    }

    ChannelHandlerContext ctx;
	/**
	 * tcp链路简历成功后调用
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		this.ctx = ctx;
		sendMsg("客户端消息");
	}

	public boolean sendMsg(String msg){
		System.out.println("客户端发送消息："+msg);
		byte[] req = msg.getBytes();
		ByteBuf m = Unpooled.buffer(req.length);
		m.writeBytes(req);
//		ctx.writeAndFlush(m);
		return msg.equals("q")?false:true;
	}

	/**
	 * 收到服务器消息后调用
	 * @throws UnsupportedEncodingException
	 */

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req,"utf-8");
		System.out.println("服务器消息："+body);
    }
    /**
     * 发生异常时调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
