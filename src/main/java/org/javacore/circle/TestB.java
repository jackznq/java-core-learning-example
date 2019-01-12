package org.javacore.circle;

/**
 * Created by ddfhznq on 2017/11/2.
 */
//@Service("testB")
public class TestB {
    //    @Resource
    private TestC testC;

    //    TestB(TestC testC){
    //        this.testC = testC;
    //    }
    public TestC getTestC() {
        return testC;
    }

    public void setTestC(TestC testC) {
        this.testC = testC;
    }

    /**
      * @Author znq
      * @Description //TODO
      * @Date 下午2:32 19/1/12
      * @param
      * @Return
      * */
    public void boi() {
        testC.c();
    }
}
