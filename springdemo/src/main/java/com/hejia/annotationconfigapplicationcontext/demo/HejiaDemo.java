package com.hejia.annotationconfigapplicationcontext.demo;

import com.hejia.annotationconfigapplicationcontext.bean.*;
import com.hejia.annotationconfigapplicationcontext.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class HejiaDemo {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = context.getBean(Car.class);
        System.out.println(car);
        context.close();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        // 手动设置扫描路径
//        context.scan("com.hejia.annotationconfigapplicationcontext");
        context.refresh();
        Car car = context.getBean(Car.class);
        System.out.println(car);
        context.close();
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);
        context.close();
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Company company = context.getBean(Company.class);
        Company1 company1 = context.getBean(Company1.class);
        context.close();
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Teacher teacher = context.getBean(Teacher.class);
        context.close();
    }

    @Test
    public void test6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Environment environment = context.getBean(Environment.class);
        context.close();
    }

    @Test
    public void test7() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(AppConfig.class);
        context.refresh();
        Company company = context.getBean(Company.class);
        Company1 company1 = context.getBean(Company1.class);
        context.close();
    }
}
