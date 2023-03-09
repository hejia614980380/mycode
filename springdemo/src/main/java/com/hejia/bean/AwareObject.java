package com.hejia.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AwareObject implements ApplicationContextAware, BeanNameAware {
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String s) {
//        applicationContext.getId()
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
