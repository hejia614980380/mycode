package com.hejia.annotationconfigapplicationcontext.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//public class Person implements InitializingBean, DisposableBean {
public class Person {
    private Car car;

    public Person() {
    }

    public Person(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("destroy");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet");
//    }

//    public void init() {
//        System.out.println("init");
//    }
//
//    public void destroy() {
//        System.out.println("destroy");
//    }
}
