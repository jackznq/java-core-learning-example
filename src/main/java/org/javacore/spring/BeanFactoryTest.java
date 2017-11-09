package org.javacore.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;

/**
 *  xml BeanFactory
 * Created by ddfhznq on 2017/11/7.
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory()throws Exception{
        Resource resource =new ClassPathResource("ApplicationContext.xml");
        InputStream inputStream = resource.getInputStream();
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("ApplicationContext.xml"));
//        TestC testC = (TestC)beanFactory.getBean("testC");
//        User user =(User) beanFactory.getBean("&user");
        UserFactoryBean userFactoryBean =(UserFactoryBean) beanFactory.getBean("&user");
        System.out.println(userFactoryBean);
    }
}
