package com.hejia.bean;

public abstract class AbstractObject {
    private Integer age;

    public AbstractObject() {
    }

    public AbstractObject(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public abstract void teach();
}
