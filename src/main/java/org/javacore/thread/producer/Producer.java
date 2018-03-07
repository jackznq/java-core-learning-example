package org.javacore.thread.producer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by znq on 2018/3/7.
 */
public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        String name = "生产者线程" + Thread.currentThread().getName();
        System.out.println(name);
        try {
            queue.put(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
