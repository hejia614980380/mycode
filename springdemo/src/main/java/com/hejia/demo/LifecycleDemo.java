package com.hejia.demo;

import com.hejia.bean.LifecycleObject;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleDemo {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
        context.registerShutdownHook();
//        context.close();
    }
}
