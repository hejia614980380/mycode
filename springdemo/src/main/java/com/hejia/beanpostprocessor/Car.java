package com.hejia.beanpostprocessor;

public class Car {
    private String num;

    private String brand;

    public Car() {
    }

    public Car(String num, String brand) {
        this.num = num;
        this.brand = brand;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "num='" + num + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
