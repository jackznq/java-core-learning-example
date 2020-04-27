package org.javacore.thread.producer;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

/**
 * Created by znq on 2018/3/7.
 */
public class Producer implements Runnable {

    BlockingQueue<String> queue;

    private int timeOut;

    public Producer(BlockingQueue<String> queue, int timeOut) {
        this.queue = queue;
        this.timeOut = timeOut;
    }

    @Override
    public void run() {
        while (true) {

            try {
                String name = UUID.randomUUID() + "name";
                queue.put(name);
                System.out.println(name+"当前库存为:"+queue.size());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
