package org.javacore.netty.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @Date 18/12/17 下午9:42
 * @Auther znq
 * @ClassName NIOZeroCopyServer
 **/
public class NIOZeroCopyClient {

    public static void main(String[] args) throws Exception {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8891));
        socketChannel.configureBlocking(true);
        String fileName = "/Users/wuyanyan/Downloads/sogou_mac_47e.zip";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long startTIme = System.currentTimeMillis();
        //实际传递的字节数
        long l = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("字节数:" + l + "耗时:" + (System.currentTimeMillis() - startTIme));

    }
}
