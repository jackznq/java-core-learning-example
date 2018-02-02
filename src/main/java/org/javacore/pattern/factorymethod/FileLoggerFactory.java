package org.javacore.pattern.factorymethod;

public class FileLoggerFactory implements LoggerFactory {
    
    public Logger createLogger() {
        //创建文件日志记录器对象
        //创建文件，代码省略
        return new FileLogger();
    }
}
