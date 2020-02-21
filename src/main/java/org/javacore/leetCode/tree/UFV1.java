package org.javacore.leetCode.tree;

/**
 * 并查集 通过树实现
 * 该树比较特殊，孩子指向父亲
 */
class UFV1 extends AbstractUF {


    public UFV1(int size) {
        super(size);
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void connectElements(int p, int q) {
        int pv = find(p);
        int qv = find(p);
        if (pv == qv)
            return;
        parent[pv] = qv;
    }


}
