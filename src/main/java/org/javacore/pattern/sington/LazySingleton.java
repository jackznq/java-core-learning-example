package org.javacore.pattern.sington;

/**
 * 懒汉式单例
 */
class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    //每次创建都要进行判断,所以高并发线程降低
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    //改进后，只对部分代码进行锁定
    public static LazySingleton getInstance1() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

    //双重检查锁定改进，很麻烦，建议使用饿汉式
    public static LazySingleton getInstance2() {
        //第一重判断
        if (instance == null) {
            //锁定代码块
            synchronized (LazySingleton.class) {
                //第二重判断
                if (instance == null) {
                    instance = new LazySingleton(); //创建单例实例
                }
            }
        }
        return instance;
    }
}
