package org.javacore.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: java-core-learning-example
 * @description: spring配置类
 * @author: znq
 * @create: 2020-05-08 10:53
 **/
@Configuration
@ComponentScan(value = "org.javacore.spring")
public class SpringConfig {

//    @Bean(initMethod = "init",destroyMethod = "myDestroy")
//    public User user() {
//        return new User();
//
//    }

}
