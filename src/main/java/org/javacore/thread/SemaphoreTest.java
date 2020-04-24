package org.javacore.thread;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * Created by ddfhznq on 2018/1/17.
 */
public class SemaphoreTest {

    //停车场
    static final class Parking {

        private Semaphore semaphore;

        //count代表停车场的停车位
        public Parking(int count) {
            semaphore = new Semaphore(count);
        }

        public void park() {
            //获得许可进入停车场
            try {
                semaphore.acquire();
                long time = (long) (Math.random() * 10);
                System.out.println(Thread.currentThread().getName() + "进入停车场，停车" + time + "秒...");
                Thread.sleep(time);
                System.out.println(Thread.currentThread().getName() + "开出停车场...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    static class Car extends Thread {

        private Parking parking;

        public Car(Parking parking){
            this.parking =parking;
        }
        @Override
        public void run() {
            parking.park();//进入停车场
        }
    }

    public static void main(String[] args) {
        Parking parking = new Parking(5);
        for (int i= 0;i<8;i++){
            new Car(parking).start();
        }
    }
}
