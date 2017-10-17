package org.javacore.prictice;

import org.javacore.utils.PrimeUtils;

import java.util.List;

/**
 * 一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程
 * 找出1000以内的所有完数
 * Created by ddfhznq on 2017/10/17.
 */
public class PerfectData {
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            List list = PrimeUtils.getPrimes(i);
            int a = 0;
            for (Object o:list){
                a = a+(int)o;
            }
            if (a==i){
                System.out.println("完数 "+i);
            }
        }
    }
}
