package com.hejia.annotationconfiguration.bean;

import org.springframework.beans.factory.annotation.Value;

public class ValueCar {
    @Value("${car.num}")
    private String num;

    @Value("${car.brand}")
//    @Value("${car.brand1}")
//    @Value("${car.brand1:法拉利}")
    private String brand;

    public ValueCar() {
    }

    public ValueCar( String num, String brand) {
        this.num = num;
        this.brand = brand;
    }

    public String getNum() {
        return num;
    }

//    @Value("${car.num}")
    public void setNum(String num) {
        this.num = num;
    }

    public String getBrand() {
        return brand;
    }

//    @Value("${car.brand}")
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
