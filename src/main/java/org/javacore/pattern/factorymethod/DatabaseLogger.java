package org.javacore.pattern.factorymethod;

public class DatabaseLogger implements Logger {
    public void writeLog() {
        System.out.println("数据库日志记录。");
    }
}
