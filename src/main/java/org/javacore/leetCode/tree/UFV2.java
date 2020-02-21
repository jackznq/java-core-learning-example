package org.javacore.leetCode.tree;

/**
 * 并查集 通过树实现
 * 该树比较特殊，孩子指向父亲
 */
class UFV2 implements UF {

    private int parent[];


    public UFV2(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return false;
    }

    @Override
    public void connectElements(int p, int q) {

    }


    private int getParent(int p) {

    }
}
