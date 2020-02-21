package org.javacore.leetCode.tree;

/**
 * 并查集 通过树实现
 * 该树比较特殊，孩子指向父亲
 */
public abstract class AbstractUF implements UF {

    protected int parent[];


    public AbstractUF(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }



    protected int find(int p) {
        return parent[p];
    }
}
