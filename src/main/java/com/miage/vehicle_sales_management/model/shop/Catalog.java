package com.miage.vehicle_sales_management.model.shop;

import com.miage.vehicle_sales_management.model.cars.Vehicle;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Vehicle> vehicles;

    public Catalog() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
