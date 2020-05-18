package org.javacore.spi;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: java-core-learning-example
 * @description: Spi
 * @author: znq
 * @create: 2020-05-08 17:32
 **/
public class SpiMain {

    public static void main(String[] args) {
//        ServiceLoader<SpiDemo> serviceLoader = ServiceLoader.load(SpiDemo.class);
//        for (SpiDemo o : serviceLoader) {
//            o.say();
//        }

        Map map = new HashMap();
        map.put("string1",1);
        map.put("string2",1);
        map.put("string3",1);
        map.put("string4",1);
        String s = JSON.toJSONString(map);
        System.out.println(s);
        Map map1 = JSON.parseObject(s);
        System.out.println(map1);
    }
}
