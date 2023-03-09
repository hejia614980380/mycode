package com.hejia.annotationconfigapplicationcontext.bean;

public class Company1 {
    private Car car;

    public Company1() {
    }

    public Company1(Car car) {
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
        return "Company{" +
                "car=" + car +
                '}';
    }
}
