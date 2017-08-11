package org.javacore.thread;

public class Test2 {
    class Worker implements Runnable {
        private String id;
        Object pre;
        Object after;

        public Worker(String id, Object pre, Object after) {
            this.id = id;
            this.pre = pre;
            this.after = after;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    synchronized (pre) {
                        pre.wait();
                    }
                    System.out.println(id);
                    synchronized (after) {
                        after.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void fun() throws InterruptedException {
        Object lockA_B = new Object();
        Object lockB_C = new Object();
        Object lockC_A = new Object();

        new Thread(new Worker("A", lockC_A, lockA_B)).start();
        Thread.sleep(100);
        new Thread(new Worker("B", lockA_B, lockB_C)).start();
        Thread.sleep(100);
        new Thread(new Worker("C", lockB_C, lockC_A)).start();
        Thread.sleep(100);
        synchronized (lockC_A) {
            lockC_A.notify();
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        new Test2().fun();
    }
}
