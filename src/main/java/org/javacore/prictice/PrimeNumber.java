package org.javacore.prictice;

import org.javacore.utils.PrimeUtils;

/**
 * 101-200的素数
 * Created by ddfhznq on 2017/10/17.
 */
public class PrimeNumber {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            if (PrimeUtils.isPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }


}
