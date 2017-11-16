package org.javacore.netty.callbacks;

/**
 *  回调的数据模型
 * Created by ddfhznq on 2017/9/26.
 */
public class Data {

    private int m;

    private int n;

    Data(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Data{" +
            "m=" + m +
            ", n=" + n +
            '}';
    }
}
