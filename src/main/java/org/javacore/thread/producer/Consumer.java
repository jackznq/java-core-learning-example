package org.javacore.thread.producer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by znq on 2018/3/7.
 */
public class Consumer implements Runnable{

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
//        String temp = null;
        try {
            String  temp = queue.take();
            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
