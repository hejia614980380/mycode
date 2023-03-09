package com.hejia.annotationconfigapplicationcontext.bean;

public class Company {
    private Car car;

    public Company() {
    }

    public Company(Car car) {
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
