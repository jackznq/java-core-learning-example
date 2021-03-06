package org.javacore.leetCode.tree;

/**
 * 并查集 通过树实现
 * 基于rank的优化
 */
class UFV4 extends AbstractUF {


    private int[] rank;

    public UFV4(int size) {
        super(size);
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            rank[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void connectElements(int p, int q) {
        int pv = find(p);
        int qv = find(q);
        if (pv == qv)
            return;
        if (rank[pv] < rank[qv]) {
            parent[pv] = qv;
        } else if (rank[pv] > rank[qv]) {
            parent[qv] = pv;
        } else {
            parent[qv] = pv;
            rank[pv] += 1;
        }
    }


    @Override
    public int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException("illegal args");
        }
        //递归处理 直接找到根节点,但是有一定的开销,性能比第三版差
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }


}
