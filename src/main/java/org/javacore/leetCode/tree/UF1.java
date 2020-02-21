package org.javacore.leetCode.tree;

/**
 * 并查集
 */
class UFV1 implements UF {

    private int[] data;

    public UFV1(int size) {
        this.data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
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
        for (int i = 0; i < data.length; i++) {
            if (pv == data[i]) {
                data[i] = qv;
            }
        }
    }

    private int find(int p) {
        return data[p];
    }
}
