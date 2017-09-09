package org.javacore.pattern.adapter;

/**
 * 德国宾馆
 * Created by ddfhznq on 2017/9/9.
 */
public class Hotel {

    private DBSocketInterface dbSocket;

    Hotel() {
    }

    public Hotel(DBSocketInterface dbSocket) {
        this.dbSocket = dbSocket;
    }


    public void setDbSocket(DBSocketInterface dbSocket) {
        this.dbSocket = dbSocket;
    }

    public void charge() {

        //使用德标接口充电
        dbSocket.powerWithTwoRound();
    }
}
