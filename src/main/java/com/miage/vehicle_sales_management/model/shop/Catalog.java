package com.miage.vehicle_sales_management.model.shop;

import com.miage.vehicle_sales_management.model.cars.Vehicle;

import java.util.ArrayList;

public class Catalog {
    private static Catalog instance;
    private ArrayList<Vehicle> vehicles;

    public Catalog() {
        this.vehicles = new ArrayList<>();
    }

    public static Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
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

    public void clearCatalog() {
        vehicles.clear();
    }
}
