package org.javacore.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock学习
 * 定义仓库类
 * Created by ddfhznq on 2017/9/22.
 */
public class Depot {

    private int capacity;//仓库容量

    private Lock lock; //仓库有一把锁

    private Condition full;//仓库状态

    private Condition empty;

    private int size;        // 仓库的实际数量

    public Depot(int capacity) {
        this.capacity = capacity;//初始化仓库容量
        size = 0;
        lock = new ReentrantLock();//给仓库枷锁

        full = lock.newCondition();
        empty = lock.newCondition();
    }

    //生产数据
    public void produce(int val)  {
        lock.lock();

        try {
            // left 表示“想要生产的数量”(有可能生产量太多，需多此生产)
            int left = val;
            while (left > 0) {
                // 库存已满时，等待“消费者”消费产品。

                while (size > capacity) {
                    full.await();
                }
                // 获取“实际生产的数量”(即库存中新增的数量)
                // 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
                // 否则“实际增量”=“想要生产的数量”
                int inc = (size + val) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                    Thread.currentThread().getName(), val, left, inc, size);
                // 通知“消费者”可以消费了。
                empty.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            // left 表示“客户要消费数量”(有可能消费量太大，库存不够，需多此消费)
            int left = val;
            while (left > 0) {
                // 库存为0时，等待“生产者”生产产品。
                while (size == 0) {
                    empty.await();
                }
                // 获取“实际消费的数量”(即库存中实际减少的数量)
                // 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
                // 否则，“实际消费量”=“客户要消费的数量”。
                int dec = (size < left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                    Thread.currentThread().getName(), val, left, dec, size);
                full.signal();
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "capacity:"+capacity+", actual size:"+size;
    }
}
