package com.hejia.demo;

import com.hejia.bean.Sex;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansDemo {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Sex sex = context.getBean("sex", Sex.class);
        System.out.println(sex);
        context.close();
    }
}
