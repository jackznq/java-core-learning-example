package org.javacore.operator;

/**
 * @Date 18/12/28 下午6:38
 * @Auther znq
 * @ClassName RelationalOperator
 **/
public class RelationalOperator {

    //关系运算符
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("a == b = " + (a == b) );//false
        System.out.println("a != b = " + (a != b) );//true
        System.out.println("a > b = " + (a > b) );//false
        System.out.println("a < b = " + (a < b) );//true
        System.out.println("b >= a = " + (b >= a) );//true
        System.out.println("b <= a = " + (b <= a) );//false
    }
}
