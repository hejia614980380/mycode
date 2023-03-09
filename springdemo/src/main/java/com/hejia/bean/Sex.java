package com.hejia.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class Sex implements InitializingBean, DisposableBean {
public class Sex {
    private Integer id;

    private String text;

    public Sex() {
    }

    public Sex(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

//    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

//    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void init() throws Exception {
        System.out.println("init");
    }
}
