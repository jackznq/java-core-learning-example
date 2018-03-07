package org.javacore.thread.producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by znq on 2018/3/7.
 */
public class Client {

    public static void main(String[] args) {
        BlockingQueue<String> queue =new LinkedBlockingQueue<>(2);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        for (int i = 0;i<5;i++){
            new Thread(producer).start();
            new Thread(consumer).start();
        }
    }
}
