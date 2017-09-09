package org.javacore.pattern.adapter;

/**
 * 适配接口测试
 * Created by ddfhznq on 2017/9/9.
 */
public class Main {

    public static void main(String[] args) {

        //带充电器去旅游
        GBSocketInterface gb = new GBSocket();
        //住宾馆
        Hotel hotel = new Hotel();
        //充电接口不兼容，需要拿适配接口即转接头
        SocketAdapter socketAdapter = new SocketAdapter(gb);
        //转接头插入到宾馆的接口
        hotel.setDbSocket(socketAdapter);
        //充电
        hotel.charge();
    }
}
