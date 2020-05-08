package org.javacore.spi.spiImpl1;

import org.javacore.spi.spiapi.SpiDemo;

/**
 * @program: java-core-learning-example
 * @description: SpiDemoimpl1
 * @author: znq
 * @create: 2020-05-08 17:27
 **/
//@Service("spiDemoImpl1")
public class SpiDemoImpl1 implements SpiDemo {

    @Override
    public void say() {
        System.out.println("SpiDemoImpl1");
    }
}
