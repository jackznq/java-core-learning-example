package org.javacore.thread.lock;

/**
 * 生产者
 * Created by ddfhznq on 2017/9/22.
 */
public class Producer {

    //仓库
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(int val) {
        new Thread(() ->
            depot.produce(val))
            .start();
    }
}
