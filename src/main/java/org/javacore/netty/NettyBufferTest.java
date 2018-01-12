package org.javacore.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

/**
 * Created by ddfhznq on 2018/1/11.
 */
public class NettyBufferTest {

    public static void main(String[] args) {
        unPooledBUfTest();
        pooledBUfTest();

    }

    private final static void pooledBUfTest() {
        int loop = 3000000;
        long startTime = System.currentTimeMillis();
        ByteBuf byteBuf = null;
        for (int i = 0; i < loop; i++) {
            byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(1024);
            byteBuf.writeBytes("dfdf".getBytes());
            byteBuf.release();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime));
    }

    private final static void unPooledBUfTest() {
        int loop = 3000000;
        long startTime = System.currentTimeMillis();
        ByteBuf byteBuf;
        for (int i = 0; i < loop; i++) {
            byteBuf = Unpooled.directBuffer(1024);
            byteBuf.writeBytes("dfdf".getBytes());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime));
    }
}
