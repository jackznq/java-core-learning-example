package org.javacore.thread.threadlocal;

/**
 *
 *  threadLocal测试
 * Created by ddfhznq on 2018/1/12.
 */
public class SeqCount {

    private static final ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        // 实现initialValue()
        public Integer initialValue() {
            return 0;
        }
    };

    public int nextSeq(){
        count.set(count.get()+1);

        return count.get();
    }

    public static void main(String[] args) {
        SeqCount seqCount = new SeqCount();

        SeqThread thread1 = new SeqThread(seqCount);
        SeqThread thread2 = new SeqThread(seqCount);
        SeqThread thread3 = new SeqThread(seqCount);
        SeqThread thread4 = new SeqThread(seqCount);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
    private static class SeqThread extends Thread{

        private SeqCount seqCount;

        SeqThread(SeqCount seqCount){
            this.seqCount = seqCount;
        }
        @Override
        public void run(){
            for (int i=0 ;i<=3;i++){
                System.out.println(Thread.currentThread().getName()+" seqCount "+seqCount.nextSeq());
            }
        }
    }
}
