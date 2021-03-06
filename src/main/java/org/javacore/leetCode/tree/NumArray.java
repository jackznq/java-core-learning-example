package org.javacore.leetCode.tree;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
class NumArray {

    private interface Merger<E> {
        E merge(E a, E b);
    }
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < data.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }


    private class SegmentTree<E> {


        private E[] data;
        private E[] tree;
        private Merger<E> merger;

        public SegmentTree(E[] data, Merger<E> merger) {
            this.data = data;
            this.tree = (E[]) new Object[4 * data.length];
            this.merger = merger;
            buildSegmentTree(0, 0, data.length - 1);
        }

        public E get(int index) {
            return data[index];
        }

        public int getLength() {
            return data.length;
        }


        private void buildSegmentTree(int index, int left, int right) {
            if (left == right) {
                tree[index] = data[left];
                return;
            }
            int leftChild = leftChild(index);
            int rightChild = rightChild(index);
            int mid = (left + right) / 2;
            buildSegmentTree(leftChild, left, mid);
            buildSegmentTree(rightChild, mid + 1, right);
            tree[index] = merger.merge(tree[leftChild], tree[rightChild]);
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }


        public E query(int l, int r) {
            if (l < 0 || r < 0 || l >= data.length || r >= data.length || l > r) {
                throw new IllegalArgumentException("args is illegal");
            }
            return query(0, 0, data.length - 1, l, r);
        }

        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (l == queryL && r == queryR) {
                return tree[treeIndex];
            }
            int mid = l + (r - l) / 2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);

            if (queryL >= mid + 1) {
                return query(rightChild, mid + 1, r, queryL, queryR);
            } else if (queryR <= mid) {
                return query(leftChild, l, mid, queryL, queryR);
            }
            //查左边
            E leftResult = query(leftChild, l, mid, queryL, mid);
            E rightResult = query(rightChild, mid + 1, r, mid + 1, queryR);

            return merger.merge(leftResult, rightResult);
        }




        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) {
                    sb.append(tree[i]);
                } else {
                    sb.append("null");
                }
                if (i != tree.length - 1) {

                }
            }
            sb.append("]");
            return sb.toString();
        }

        public void set(int index, E val) {
            if (index < 0 || index > data.length) {
                throw new IllegalArgumentException("index is Ilegal");
            }
            data[index] = val;
            set(0, 0, data.length - 1, index, val);
        }

        private void set(int treeIndex, int l, int r, int index, E e) {
            if (l == r) {
                tree[treeIndex] = e;
                return;
            }
            int mid = l + (r - l) / 2;
            int leftChild = leftChild(treeIndex);
            int rightChild = rightChild(treeIndex);
            if (index >= mid + 1) {
                set(rightChild, mid + 1, r, index, e);
            } else {
                set(leftChild, l, mid, index, e);
            }
            tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
