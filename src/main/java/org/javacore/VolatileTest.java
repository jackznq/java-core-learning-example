package org.javacore;

/**
 * Created by ddfhznq on 2017/8/4.
 */
public class VolatileTest
{
     int a=0;
      int b = 0;

    private void write(){
        a=5;
        b=1;
        System.out.println(a);
        System.out.println(b);
    }

    private void read(){
        int dump=b;
        while (a!=5){
            System.out.println(a);
            System.out.println(dump);
        }
    }

    public static void main(String[]args)throws Exception{
        VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                volatileTest.write();
            }
        });
        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                volatileTest.read();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
