package org.javacore.circle;

/**
 * Created by ddfhznq on 2017/11/2.
 */
//@Service("testC")
public class TestC {
    //    @Resource
    private TestA testA;

//    TestC(TestA testA) {
//        this.testA = testA;
//    }

    public TestA getTestA() {
        return testA;
    }

    public void setTestA(TestA testA) {
        this.testA = testA;
    }

    public void c() {
        testA.a();
    }
}
