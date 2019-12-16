package org.javacore.leetCode.practice;

import org.apache.commons.collections.CollectionUtils;
import org.javacore.utils.PrimeUtils;

import java.util.List;

/**
 * 将一个整数分解质因数
 * Created by ddfhznq on 2017/10/17.
 */
public class PrimeFactorCount {

    public static void main(String[] args) {
        int i = 50050;
        StringBuffer sb = new StringBuffer();
        List lists = getPrimes(i);
        Object[] objects = lists.toArray();
        if (CollectionUtils.isNotEmpty(lists)) {
            for (int j = 0; j < objects.length; j++) {
                sb.append(objects[j]);
                if (j!=objects.length){
                    sb.append("*");
                }
            }
        }
        sb.append("=" + i);
        System.out.println(sb.toString());
    }

    public static List getPrimes(int i) {
        if (i <= 1) return null;
        return PrimeUtils.getPrimes(i);
    }
}
