package org.javacore.leetCode.tree;


class Solution {

    public static void main(String[] args) {

        //并查集测试
        int size =1000000;
        int m =100000;
        UFV1 uf1 =new UFV1(size);
        System.out.println(uf1.testUF(uf1,m));
        UFV2 uf2 =new UFV2(size);
        System.out.println(uf2.testUF(uf2,m));
    }


}
