package org.javacore.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Jeff Lee
 * @since 2015-6-18 21:05:38
 * ArrayList的使用
 */
public class ArrayListT {

    private static final int COUNT = 10000;
    private static List<Integer> persons = new ArrayList<>();

    public static void main(String[] args) {
        init();
        System.out.println("Iterator迭代遍历的消耗时间为:" + testIterator(persons) + "s");
        System.out.println("ForEach遍历的消耗时间为:" + testForEach(persons) + "s");
        System.out.println("For循环遍历的消耗时间为:" + testFor(persons) + "s");
    }

    public static void init() {
        //初始化，生成对象个数
        for (int i = 0; i < COUNT; i++) {
            persons.add(i);
        }
    }


    /**
     * 测试ArrayList基本操作方法，其角标的使用及迭代器next()的使用。
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void listMethods() {

        List<Integer> integers = new ArrayList<>(100000);
        for (int a = 0; a < 100000; a++) {
            int i = (int) (Math.random() * 100);
            integers.add(i);
        }

        //foreach
        Long startForEach = System.currentTimeMillis();
        for (int i : integers) {
            System.out.println(i);
        }
        Long endForEach = System.currentTimeMillis();

        System.out.println("ForEach耗时" + (endForEach - startForEach));

        int size = integers.size();
        Long startIterator = System.currentTimeMillis();
        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
        Long endIterator = System.currentTimeMillis();

        System.out.println("Iterator耗时" + (endIterator - startIterator));

        Long startGeneralFor = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            System.out.println(integers.get(i));
        }
        Long endGeneralFor = System.currentTimeMillis();
        System.out.println("GeneralFor耗时" + (endGeneralFor - startGeneralFor));
    }

    //Iterator遍历
    private static long testIterator(List<Integer> integers) {
        //开始编译执行时间
        long start = System.currentTimeMillis();
        for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext(); ) {
            iterator.next();

        }
        //执行完后的时间
        long end = System.currentTimeMillis();
        return (end - start);
    }

    //foEach循环遍历
    private static long testForEach(List<Integer> integers) {
        //开始编译执行时间
        long start = System.currentTimeMillis();
        for (Integer p : integers) {

        }
        //执行完后的时间
        long end = System.currentTimeMillis();
        return (end - start);
    }

    //for循环遍历
    private static long testFor(List<Integer> integers) {
        //开始编译执行时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < integers.size(); i++) {
            integers.get(i);
        }
        //执行完后的时间
        long end = System.currentTimeMillis();
        return end - start;

    }

}
