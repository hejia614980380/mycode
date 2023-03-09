package com.hejia.environment.demo;

import com.hejia.environment.bean.Car;
import com.hejia.environment.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.ThreadLocalRandom;

public class HejiaDemo {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 设置启用的profile
//        context.getEnvironment().setActiveProfiles("test");
        // 设置默认profile名称
        context.getEnvironment().setDefaultProfiles("defaults");
        context.register(AppConfig.class);
        context.refresh();
        Car car = context.getBean(Car.class);
        System.out.println(car);
        context.close();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        boolean flag = environment.containsProperty("car.num");
        if (flag) {
            String carNum = environment.getProperty("car.num");
            System.out.println(carNum);
        }
        context.close();
    }

    @Test
    public void test3() {
        System.out.println(ThreadLocalRandom.current().nextInt(10));
    }
}
