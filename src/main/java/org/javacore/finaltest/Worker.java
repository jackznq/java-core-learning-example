package org.javacore.finaltest;

class Worker implements Runnable{
        @Override
        public void run() {
            FinalExample.writer();
            System.out.println("final writer 测试");
        }
    }
