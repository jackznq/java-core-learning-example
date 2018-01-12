package org.javacore.pbrpc;

import org.javacore.pbrpc.service.impl.DemoServiceImpl;

/**
 * Created by ddfhznq on 2018/1/10.
 */
public class PbrpcTest {

    public static void main(String[] args) throws Exception {
        PbrpcServer server = new PbrpcServer(8988);
        server.register(100, new DemoServiceImpl());
        server.start();
        Thread.sleep(2000);
        PbrpcClient client = new PbrpcClient();
        client.run(8988, 8, 1000, 100, 1000);
    }
}
