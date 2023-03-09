package com.hejia.annotationconfiguration.demo;

import com.hejia.annotationconfiguration.bean.*;
import com.hejia.annotationconfiguration.service.SimpleService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;

public class AnnotationConfigurationDemo {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationConfiguration.xml");
        MovieRecommender movieRecommender = context.getBean("movieRecommender", MovieRecommender.class);
        context.close();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationConfiguration.xml");
        QualifierMovieRecommender qualifierMovieRecommender = context.getBean("qualifierMovieRecommender", QualifierMovieRecommender.class);
        context.close();
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationConfiguration.xml");
        ResourceMovieListener resourceMovieListener = context.getBean("resourceMovieListener", ResourceMovieListener.class);
        context.close();
    }

    /**
     * 1. @Value生效的两种配置
     * 1.1 <context:property-placeholder location="car.properties"/>
     * 1.2 <context:component-scan base-package="com.hejia"/> + 在配置类(@Configuration)中配置@PropertySource("application.properties")
     */
    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationConfiguration.xml");
        ValueCar valueCar = context.getBean("valueCar", ValueCar.class);
        System.out.println(valueCar);
        context.close();
    }

    @Test
    public void test5() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationConfiguration.xml");
        ConvertObject convertObject = context.getBean("convertObject", ConvertObject.class);
        context.close();
    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationConfiguration.xml");
        SimpleService simpleService = context.getBean(SimpleService.class);
        context.close();
    }

    @Test
    public void test7() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationConfiguration.xml");
        // testBean和testBean_ 不会是同一个对象
        TestBean testBean = context.getBean(TestBean.class);
        FactoryMethodComponent factoryMethodComponent = context.getBean(FactoryMethodComponent.class);
        TestBean testBean_ = factoryMethodComponent.publicInstance();
        System.out.println(testBean);
        context.close();
    }
}
