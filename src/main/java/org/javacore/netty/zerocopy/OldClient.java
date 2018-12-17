package org.javacore.netty.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class OldClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8890);
        String file = "/Users/wuyanyan/Downloads/sogou_mac_47e.zip";
        InputStream inputStream = new FileInputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[1024];
        long readCount;
        long total = 0;
        long startTime = System.currentTimeMillis();
        while ((readCount = inputStream.read(bytes)) >= 0) {
            total += readCount;
            dataOutputStream.write(bytes);

        }
        System.out.println("总字节数:" + total + "消耗时间:" + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        inputStream.close();
        socket.close();
    }
}
