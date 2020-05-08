package org.javacore.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * xml BeanFactory
 * Created by ddfhznq on 2017/11/7.
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() throws Exception {

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        User user = (User) beanFactory.getBean("user");
//        System.out.println(user);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        User bean = applicationContext.getBean(User.class);
//        String[] beanNamesForType = applicationContext.getBeanDefinitionNames();
        System.out.println(bean);
//        Arrays.stream(beanNamesForType).forEach(System.out::println);
        applicationContext.close();
    }
}
