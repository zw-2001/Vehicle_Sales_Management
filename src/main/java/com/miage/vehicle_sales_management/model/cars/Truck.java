package com.miage.vehicle_sales_management.model.cars;

public class Truck extends Vehicle {
    private String type;

    public Truck() {
    }

    public Truck(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
