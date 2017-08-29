package org.javacore.pattern.sington;

/**
 *  饿汉式单例，缺点，无法实现延迟加载
 */
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() { }

    public static EagerSingleton getInstance() {
        return instance;
    }

    //改用静态内部类使用
    private static class HolderClass {
        private final static EagerSingleton instance = new EagerSingleton();
    }

    public static EagerSingleton getInstance1() {
        return HolderClass.instance;
    }

    public static void main(String args[]) {
        EagerSingleton s1, s2;
        s1 = EagerSingleton.getInstance();
        s2 = EagerSingleton.getInstance();
        System.out.println(s1==s2);
    }
}
