package org.javacore.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Date 18/12/13 上午10:49
 * @Auther znq
 * @ClassName SelectorT
 **/
public class SelectorT {

    public static void main(String[] args) throws Exception {
//        int i = SelectionKey.OP_READ | SelectionKey.OP_ACCEPT;
//        System.out.println(i);
        //定义长度为5的数据存放端口号
        int ports[] = {5000, 5001, 5002, 5003, 5004};

        //create selector
        Selector selector = Selector.open();
        for (int port : ports) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket socket = serverSocketChannel.socket();
            SocketAddress address = new InetSocketAddress(port);
            socket.bind(address);
            //Registering Channels with the Selector
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("---------");
        }

        while (true) {
            int select = selector.select();
            System.out.println("numbers: " + select);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys: " + selectionKeys);
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);

                    accept.register(selector, SelectionKey.OP_READ);

                    System.out.println("客户端连接: " + accept);
                    //事件处理完成之后需要直接删除，不需要再次监听
                    iterator.remove();
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                    iterator.remove();

                } else if (key.isReadable()) {
                    // a channel is ready for reading
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    int byteRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        byteBuffer.clear();

                        int read = socketChannel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteRead += read;

                        System.out.println("读取的数据: " + byteRead + ",来自于 " + socketChannel);
                        //事件处理完成之后需要直接删除，不需要再次监听
                        iterator.remove();
                    }

                } else if (key.isWritable()) {
                    // a channel is ready for writing
                    iterator.remove();
                }


            }
        }


    }
}
