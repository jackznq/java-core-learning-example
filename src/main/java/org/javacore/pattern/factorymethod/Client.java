package org.javacore.pattern.factorymethod;

/**
 * Created by ddfhznq on 2017/9/12.
 */
public class Client {

    public static void main(String [] args){
//        Factory factory = new ConcreteFactory();
//         factory.getProduct();
        LoggerFactory factory;
        Logger logger;
        factory = new FileLoggerFactory(); //可引入配置文件实现
        logger = factory.createLogger();
        logger.writeLog();
    }
}
