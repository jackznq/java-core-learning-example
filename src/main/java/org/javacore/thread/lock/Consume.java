package org.javacore.thread.lock;

/**
 * 生产者
 * Created by ddfhznq on 2017/9/22.
 */
public class Consume {

    //仓库
    private Depot depot;

    public Consume(Depot depot) {
        this.depot = depot;
    }

    public void consume(int val) {
        new Thread(() -> depot.consume(val)).start();
    }
}
