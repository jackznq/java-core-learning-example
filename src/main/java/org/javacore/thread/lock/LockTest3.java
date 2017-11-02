package org.javacore.thread.lock;

/**
 *  测试类
 * Created by ddfhznq on 2017/9/22.
 */
public class LockTest3 {

    public static void main(String []args){
        Depot depot = new Depot(60);
        Producer producer = new Producer(depot);
        Consume consume = new Consume(depot);
        consume.consume(15);
        producer.produce(10);
        producer.produce(10);
        producer.produce(10);
        producer.produce(10);

        consume.consume(15);
        producer.produce(15);


    }
}
