package org.javacore.operator;

/**
 * @Date 18/12/28 下午6:32
 * @Auther znq
 * @ClassName SelfDecreasingDecrement
 **/
public class SelfDecreasingDecrement {

    public static void main(String[] args) {
        int a = 3;//定义一个变量；
        int b = ++a;//自增运算  b =4
        int c = 3;
        int d = --c;//自减运算 d =2
        System.out.println("进行自增运算后的值等于" + b);
        System.out.println("进行自减运算后的值等于" + d);

        int x = 2 * ++a; //10
        int y = 2 * b++; //9
        System.out.println("自增运算符前缀运算后a=" + a + ",x=" + x); // a= 5,x =10
        System.out.println("自增运算符后缀运算后b=" + b + ",y=" + y); // b= 5,y =8
    }
}
