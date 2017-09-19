package org.javacore.finaltest;

class Worker1 implements Runnable{
        @Override
        public void run() {
            FinalExample finalExample = new FinalExample();
            FinalExample.reader();
            System.out.println("final reader 测试");
        }
    }
