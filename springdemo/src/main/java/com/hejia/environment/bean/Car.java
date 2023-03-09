package com.hejia.environment.bean;

public class Car {
    private Integer id;

    private String vehicleNum;

    private String brand;

    public Car() {
    }

    public Car(Integer id, String vehicleNum, String brand) {
        this.id = id;
        this.vehicleNum = vehicleNum;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
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
                "id=" + id +
                ", vehicleNum='" + vehicleNum + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
