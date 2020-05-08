package org.javacore.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @program: java-core-learning-example
 * @description: aop
 * @author: znq
 * @create: 2020-05-08 21:17
 **/
@Aspect
public class LogAspects {

    @Pointcut("execution(Integer org.javacore.spring.MathCalculator.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart(JoinPoint point) {
        Object[] args = point.getArgs();
        System.out.println("方法" + point.getSignature().getName() + "@Before" + "...运行参数:" + Arrays.asList(args));
    }

    @After("pointCut()")
    public void logEnd(JoinPoint point) {
        System.out.println("logEnd:{}" + point.getSignature().getName());

    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("运行方法:" + joinPoint.getSignature().getName() + "运行结果:{}" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {

        System.out.println(joinPoint.getSignature().getName()+"运算异常" + e);

    }
}
