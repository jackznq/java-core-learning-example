package org.javacore.operator;

/**
 * @Date 18/12/28 下午6:38
 * @Auther znq
 * @ClassName BitOperator
 **/
public class BitOperator {

    //关系运算符
    public static void main(String[] args) {
        System.out.println(-80 >> 10);
        System.out.println((10 & 1) == 0);
        int a = 10, b = 14;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + "b " + b);
        //求x与2的n次方乘积
        int x = 20;
        System.out.println(x << 4);
        //取 x 的第 k 位
        for (int i = 0; i < 8; i++) {
            System.out.println(x >> i & 1);
        }
    }
}
