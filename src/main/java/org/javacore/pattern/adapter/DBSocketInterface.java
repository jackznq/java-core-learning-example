package org.javacore.pattern.adapter;

/**
 *  根据插头的接口类型做适配
 *   中国的插头接口和德国有所区别，所以到德国旅游，在宾馆里有转接头，否则手机无法充电
 * Created by ddfhznq on 2017/9/9.
 */
public interface DBSocketInterface {

    /**
     * 这个方法的名字叫做：使用两项圆头的插口供电
     * 本人英语就这个水平
     */
    void powerWithTwoRound();
}
