package org.javacore.nio;

import java.nio.ByteBuffer;

/**
 * diffrence bytebuffer and bytebuf
 * Created by ddfhznq on 2017/11/17.
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String value = "znq";
        byteBuffer.put(value.getBytes());
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        byteBuffer.clear();
        System.out.println(new String(bytes));
    }
}
