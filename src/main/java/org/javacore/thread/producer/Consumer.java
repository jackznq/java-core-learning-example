package org.javacore.thread.producer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by znq on 2018/3/7.
 */
public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    private String consumerName;

    public Consumer(BlockingQueue<String> queue, String consumerName) {
        this.queue = queue;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
//        String temp = null;
        while (true) {
            try {
                String temp = queue.take();
                System.out.println(consumerName + "消费: " + temp + " 剩余库存" + queue.size());
                Thread.sleep(new Random().nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
