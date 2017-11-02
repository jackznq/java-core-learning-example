package org.javacore.thread;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

/**
 * 数据的可见性
 * Created by ddfhznq on 2017/10/25.
 */
@ThreadSafe
public class Novisibility {

    private static boolean ready = false;

    @GuardedBy("this") private static int number;

    private static class ReadThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String args[]) {
        new ReadThread().start();
        number = 30;
        ready = true;

    }
}
