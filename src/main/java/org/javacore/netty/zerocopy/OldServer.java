package org.javacore.netty.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统文件读取
 */
class OldServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8890);
        while (true) {
            Socket accept = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
            byte[] bytes = new byte[1024];
            while (true) {
                int read = dataInputStream.read(bytes, 0, bytes.length);
                if (read == -1) {
                    break;
                }

            }

        }
    }
}
