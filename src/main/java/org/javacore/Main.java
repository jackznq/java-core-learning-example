package org.javacore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by ddfhznq on 2017/9/15.
 */
public class Main {
    public static void main(String[] args) {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            //获取kryo对象
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 指向某个Function的方法指针
     * @author 郭胜凯
     * @emai 719348277@qq.com
     * @time 2016年7月4日 下午1:31:07
     * @param <F> 传值类型
     * @param <T> 结果类型
     */
    @FunctionalInterface
    interface Fun<F, T> {
        T run(F from);
    }

    public static String myMethod(String arg){
        return arg;
    }
    public static void myMethod1(){
        myMethod1();
    }
}
