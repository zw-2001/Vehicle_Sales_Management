package com.miage.vehicle_sales_management.model.shop;

import com.miage.vehicle_sales_management.model.vehicles.Vehicle;

import java.util.ArrayList;

/**
 * Class Catalog to manage the catalog of the website
 */
public class Catalog {
    private static Catalog instance;
    private ArrayList<Vehicle> vehicles;

    /**
     * Constructor of the class Catalog
     */
    public Catalog() {
        this.vehicles = new ArrayList<>();
    }

    /**
     * Design pattern Singleton
     * Get the instance of the catalog
     *
     * @return the instance of the catalog
     */
    public static Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    /**
     * Get the vehicles of the catalog
     *
     * @return List of vehicles in the catalog
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Remove a vehicle from the catalog
     *
     * @param vehicle The vehicle to remove
     */
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    /**
     * Get the vehicles of the catalog
     *
     * @return List of vehicles in the catalog
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Clear the catalog
     */
    public void clearCatalog() {
        vehicles.clear();
    }
}
