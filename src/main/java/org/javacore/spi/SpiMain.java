package org.javacore.spi;

import org.javacore.spi.spiapi.SpiDemo;

import java.util.ServiceLoader;

/**
 * @program: java-core-learning-example
 * @description: Spi
 * @author: znq
 * @create: 2020-05-08 17:32
 **/
public class SpiMain {

    public static void main(String[] args) {
        ServiceLoader<SpiDemo> serviceLoader = ServiceLoader.load(SpiDemo.class);
        for (SpiDemo o : serviceLoader) {
            o.say();
        }
    }
}
