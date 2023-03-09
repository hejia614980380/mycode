package com.hejia.demo;

import com.hejia.bean.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HejiaDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
//        Student student = context.getBean(Student.class);
//        System.out.println(student);
//        ClientService clientService = context.getBean("clientService", ClientService.class);
//        Sex sex = context.getBean("sex6", Sex.class);
//        ComplexObject complexObject = context.getBean("childComplexObject", ComplexObject.class);
//        Student student = context.getBean("student5", Student.class);
//        long time1 = System.currentTimeMillis();
        Sex sex1 = context.getBean("sex3", Sex.class);
        context.close();
//        long time2 = System.currentTimeMillis();
//        Sex sex2 = context.getBean("sex6", Sex.class);
//        long time3 = System.currentTimeMillis();
//        System.out.println(time3 - time2 + ":" + (time2 - time1));
    }

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
        ExtendsObject extendsObject = context.getBean("extendsObject", ExtendsObject.class);
        System.out.println(extendsObject);
        context.close();
    }
}
