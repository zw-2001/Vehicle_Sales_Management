package com.miage.vehicle_sales_management.entities.cars;

public class Car extends Vehicle {
    private String type;

    public Car() {
    }

    public Car(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
