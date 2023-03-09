package com.hejia.annotationconfiguration.bean;

public class TestBean {
    private String state;

    public TestBean() {
    }

    public TestBean(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "state='" + state + '\'' +
                '}';
    }
}
