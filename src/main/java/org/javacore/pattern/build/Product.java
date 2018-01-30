package org.javacore.pattern.build;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类,由多个部件组成
 * Created by znq on 2018/1/30.
 */
public class Product {

    private List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("输出产品各个的部件");
        for (String s : parts) {
            System.out.println(s);
        }
    }
}
