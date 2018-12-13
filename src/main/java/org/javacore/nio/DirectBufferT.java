package org.javacore.nio;

import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;

/**
 * @Date 18/12/12 下午4:37
 * @Auther znq
 * @ClassName DirectBufferT
 **/
public class DirectBufferT {

    public static void main(String[] args) throws Exception {
        ByteBuffer allocate = ByteBuffer.allocate(34);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
//        byteBuffer
        RandomAccessFile randomAccessFile = new RandomAccessFile("znq.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte)'a');
        map.put(0,(byte)'a');

        ServerSocketChannel serverSocketChannel =  ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8090);
        serverSocketChannel.socket().bind(address);
    }
}
