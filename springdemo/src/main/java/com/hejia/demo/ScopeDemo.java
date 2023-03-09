package com.hejia.demo;

import com.hejia.bean.Sex;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemo {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("scope.xml");
        Sex sex1 = context.getBean("sex1", Sex.class);
        System.out.println(sex1);
        try {
            sex1.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
