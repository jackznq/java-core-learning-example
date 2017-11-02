package org.javacore.utils;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * 判断一个数是否是质树
 * Created by ddfhznq on 2017/10/17.
 */
public class PrimeUtils {

    private static final PrimeUtils primeUtils = new PrimeUtils();

    private PrimeUtils() {

    }

    public static PrimeUtils getInstance() {
        return primeUtils;
    }

    /**
     * 判断一个数是否是质数
     *
     * @param i i
     * @return boolean
     */
    public static Boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求一个数的所有质因数
     *
     * @param i i
     * @return list
     */
    public static List getPrimes(int i) {
        if (i <= 1) {
            return Lists.newArrayList();
        }
        List primes = Lists.newArrayList();
        primes.add(1);
        if (isPrime(i)) {
            primes.add(i);
            return primes;
        }
//        for (int j = 2; j <= Math.sqrt(i); j++) {
//            int temp = i % j;
//            int discuss = i / j;
//            if (temp == 0) {
//                primes.add(j);
//                if (isPrime(discuss)) {
//                    primes.add(discuss);
//                }
//            }
//        }
        int k = 2;
        while (k <= i) {
            if (k == i) {
                primes.add(i);
                break;
            } else if (i % k == 0) {
                primes.add(k);
                i = i / k;
            } else k++;
        }

        return primes;
    }

    private List getCommonData(int i, int j) {
        List list1 = getPrimes(i);
        List list = getPrimes(j);
        List common = Lists.newArrayList();
        for (Object o : list) {
            if (list1.contains(o)) {
                common.add(o);
            }
        }
        if (i % j == 0 || j % i == 0) {
            if (i <= j) {
                common.add(i);
            } else {
                common.add(j);
            }
        }
        Collections.sort(common);
        return common;
    }

    public int getCommonDivisor(int i, int j) {
        List list = getCommonData(i, j);
        return (int) list.get(list.size() - 1);
    }

    public static int getCommonMultiple(int i, int j) {
        return 0;
    }
}
