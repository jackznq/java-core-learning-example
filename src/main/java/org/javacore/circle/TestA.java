package org.javacore.circle;

/**
 * Created by ddfhznq on 2017/11/2.
 */
//@Service("testA")
public class TestA {
//    @Resource
    private TestB testB;

//    TestA(TestB testB){
//        this.testB = testB;
//    }
    public TestB getTestB() {
        return testB;
    }

    public void setTestB(TestB testB) {
        this.testB = testB;
    }

    public void a(){
        testB.b();
    }
}
