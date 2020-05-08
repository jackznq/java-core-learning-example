package org.javacore.spring.aop;

import org.javacore.spring.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: java-core-learning-example
 * @description: config
 * @author: znq
 * @create: 2020-05-08 21:15
 **/
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    LogAspects logAspects() {
        return new LogAspects();
    }
}
