package org.javacore.base.String;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        System.out.println("-----");
        BigDecimal a = BigDecimal.valueOf(10);
        BigDecimal b = BigDecimal.valueOf(3);
        System.out.println(a.divide(b,4,BigDecimal.ROUND_HALF_DOWN ));
    }
}
