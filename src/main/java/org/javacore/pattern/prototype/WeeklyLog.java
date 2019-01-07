package org.javacore.pattern.prototype;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Date 19/1/7 上午11:29
 * @Auther znq
 * @ClassName WeeklyLog
 **/
public class WeeklyLog implements Cloneable {

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String date;

    @Setter
    @Getter
    private String Content;

    //    protected WeeklyLog clone() {
//        WeeklyLog obj;
//        try {
//            obj = (WeeklyLog) super.clone();
//        } catch (CloneNotSupportedException e) {
//            System.out.println("");
//            return null;
//        }
//
//        return obj;
//    }
    //克隆方法clone()，此处使用Java语言提供的克隆机制
    public WeeklyLog clone() {

        Object obj = null;
        try {
            obj = super.clone();

            return (WeeklyLog) obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }

}
