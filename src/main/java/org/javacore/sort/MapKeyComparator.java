package org.javacore.sort;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapKeyComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        String str1Result = result(str1);
        String str2Result = result(str2);
        return compareVersion(str1Result, str2Result);
    }

    /**
     * 比较两个数字字符串
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        int temp1 = 0, temp2 = 0;
        int len1 = version1.length(), len2 = version2.length();
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            temp1 = 0;
            temp2 = 0;
            while (i < len1 && version1.charAt(i) != '.') {
                temp1 = temp1 * 10 + version1.charAt(i++) - '0';
            }
            while (j < len2 && version2.charAt(j) != '.') {
                temp2 = temp2 * 10 + version2.charAt(j++) - '0';

            }
            if (temp1 > temp2) return 1;
            else if (temp1 < temp2) return -1;
            else {
                i++;
                j++;

            }

        }
        return 0;
    }

    private String result(String str) {

        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}
