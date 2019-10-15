package org.javacore.sort;

import org.javacore.utils.MapUtil;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Date 18/9/6 下午4:44
 * @Auther znq
 * @ClassName MapSortDemo
 **/
public class MapSortDemo {

    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<String, String>();

        map.put("1万", "1000");
        map.put("10万", "10000");
        map.put("3万", "2000");
        map.put("5万", "23223");

        Map<String, String> resultMap = MapUtil.sortMapByKey(map);   //按Key进行排序

        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
