package org.javacore.pattern.prototype;

/**
 * @Date 19/1/7 上午11:32
 * @Auther znq
 * @ClassName Client
 **/
public class Client {

    public static void main(String[] args) {
        WeeklyLog weeklyLog = new WeeklyLog();
        weeklyLog.setName("znq");
        weeklyLog.setDate("12周");
        weeklyLog.setContent("加班");
        System.out.println("周次：" + weeklyLog.getDate());
        System.out.println("姓名：" + weeklyLog.getName());
        System.out.println("内容：" + weeklyLog.getContent());

        WeeklyLog cloneWeeklyLog = weeklyLog.clone();
//        weeklyLog.setName("zwj");
//        cloneWeeklyLog.setDate("13周");
//        weeklyLog.setContent("加班,加班");
        System.out.println("周次：" + cloneWeeklyLog.getDate());
        System.out.println("姓名：" + cloneWeeklyLog.getName());
        System.out.println("内容：" + cloneWeeklyLog.getContent());

        System.out.println(weeklyLog.equals(cloneWeeklyLog));
        System.out.println(weeklyLog.getDate().equals(cloneWeeklyLog.getDate()));
        System.out.println(weeklyLog.getContent().equals(cloneWeeklyLog.getContent()));
        System.out.println(weeklyLog.getName().equals(cloneWeeklyLog.getName()));
    }
}
