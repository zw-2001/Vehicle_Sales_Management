package com.miage.vehicle_sales_management.entities.cars;

public class Motorcycle extends Vehicle {
    private String type;

    public Motorcycle() {
    }

    public Motorcycle(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
