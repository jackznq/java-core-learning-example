package org.javacore.circle;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 循环依赖测试
 * Created by ddfhznq on 2017/11/2.
 */
public class CircleTest {

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void circle() throws Throwable {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            TestA testA = (TestA) applicationContext.getBean("testA");
            System.out.println(testA);
        } catch (Exception e) {
            Throwable throwable = e.getCause().getCause().getCause();
            throw throwable;
        }
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCirCleBySetterAndScope() throws Throwable {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
            applicationContext.setAllowCircularReferences(true);
            System.out.println(applicationContext.getBean("testA"));
        } catch (Exception e){
            Throwable throwable = e.getCause().getCause();
            throw  throwable;
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }
}
