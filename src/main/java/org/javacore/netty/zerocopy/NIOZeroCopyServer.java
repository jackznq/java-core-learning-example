package org.javacore.netty.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Date 18/12/17 下午9:42
 * @Auther znq
 * @ClassName NIOZeroCopyServer
 **/
public class NIOZeroCopyServer {

    public static void main(String[] args) throws Exception {

        //绑定端口
        InetSocketAddress socketAddress = new InetSocketAddress(8891);
        //创建一通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //
        ServerSocket serverSocket = serverSocketChannel.socket();
        //关闭后的一小段处理超时状态time-wait，一个新的端口想要绑定，提示address 已经被使用了
        serverSocket.setReuseAddress(true);
        serverSocket.bind(socketAddress);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);

            int readCount = 0;
            while (-1 != readCount) {
                readCount = socketChannel.read(byteBuffer);
                //倒带，position归为到0
                byteBuffer.position(0);
            }
        }
    }
}
