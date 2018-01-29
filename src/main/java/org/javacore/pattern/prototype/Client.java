package org.javacore.pattern.prototype;

import java.util.Date;

/**
 * Created by znq on 2018/1/25.
 */
public class Client {

    public static void main(String[] args) throws Exception{
        Resume a = new Resume("znq");
        a.setPersonInfo(20,"nan");
        a.setWorkExperience(new Date(),"坐力");

        Resume b =a;
        b.setPersonInfo(27,"女");
        b.setWorkExperience(new Date(),"佐力");

        a.display();
        b.display();
        System.out.println(a);
        System.out.println(b);
    }
}


