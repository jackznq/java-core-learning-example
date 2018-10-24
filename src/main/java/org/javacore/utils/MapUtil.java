package org.javacore.utils;

import org.javacore.sort.MapKeyComparator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapUtil {
    /**
     * 使用 Map按value进行排序
     * @param oriMap
     * @return
     */
    public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, String> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, String>> entryList = new ArrayList<>(
                oriMap.entrySet());
//        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
            new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }

}
