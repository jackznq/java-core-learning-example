package org.javacore.pattern.adapter;

/**
 * 适配接口类，必须能用旧接口，还需要持有心接口，做为类型转换，也就是转换器
 * Created by ddfhznq on 2017/9/9.
 */
public class SocketAdapter implements DBSocketInterface {

    private GBSocketInterface gbSocketInterface;

    /**
     * 在创建适配器对象时，必须传入一个新街口的实现类
     * @param gbSocketInterface gbSocketInterface
     */
    public SocketAdapter(GBSocketInterface gbSocketInterface) {
        this.gbSocketInterface = gbSocketInterface;
    }


    @Override
    public void powerWithTwoRound() {
        gbSocketInterface.powerWithThreeFlat();
    }
}
