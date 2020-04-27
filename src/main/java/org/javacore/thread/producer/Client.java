package org.javacore.thread.producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by znq on 2018/3/7.
 */
public class Client {

    public static void main(String[] args) throws Exception {

        BlockingQueue<String> stock = new ArrayBlockingQueue<>(10);
        Thread p1 = new Thread(new Producer(stock, 2000));
        Thread p2 = new Thread(new Producer(stock, 500));
        Thread c1 = new Thread(new Consumer(stock,"zhangsan"));
//        Thread c2 = new Thread(new Consumer(stock, "lisi"));
//        Thread c3 = new Thread(new Consumer(stock, "wangwu"));

        p1.start();
        p2.start();
        c1.start();
//        c2.start();
//        c3.start();
    }
}
