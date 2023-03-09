package com.hejia.beanpostprocessor;

import com.hejia.bean.Sex;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorDemo {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanPostProcessor.xml");
        Sex sex = context.getBean("sex", Sex.class);
        System.out.println(sex);
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanPostProcessor.xml");
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }
}
