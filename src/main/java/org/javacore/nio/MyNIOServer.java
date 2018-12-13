package org.javacore.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @Date 18/12/13 下午4:04
 * @Auther znq
 * @ClassName MyNIOServer
 **/
public class MyNIOServer {

    private static Map<String, SocketChannel> clinetMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8099));

        //創建選擇器
        Selector selector = Selector.open();

        //注册通道到选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                final SocketChannel client;
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    try {
                        client = channel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                        //通过UUID缓存所有客户端的信息
                        String key = "[" + UUID.randomUUID().toString() + "]";
                        clinetMap.put(key, client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (selectionKey.isReadable()) {
                    client = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(512);
                    try {
                        int read = client.read(readBuffer);
                        if (read > 0) {
                            readBuffer.flip();


                            Charset charset = Charset.forName("UTF-8");
                            String receiveMessage = String.valueOf(charset.decode(readBuffer).array());
                            System.out.println(client + ":" + receiveMessage);

                            String senderKey = null;
                            for (Map.Entry<String, SocketChannel> entries : clinetMap.entrySet()) {
                                if (client == entries.getValue()) {
                                    senderKey = entries.getKey();
                                    break;
                                }
                            }

                            for (Map.Entry<String, SocketChannel> entries : clinetMap.entrySet()) {
                                SocketChannel value = entries.getValue();
                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                writeBuffer.put((senderKey + ": " + receiveMessage).getBytes());
                                writeBuffer.flip();
                                value.write(writeBuffer);
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (selectionKey.isWritable()) {

                }

            });

            selectionKeys.clear();
        }

    }
}
