package com.hejia.methodinjection;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodInjectionDemo {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("methodInjection.xml");
        CommandManager commandManager = context.getBean("commandManager", CommandManager.class);
        Object process = commandManager.process("1");
        System.out.println(process);
    }
}
