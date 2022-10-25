package com.miage.vehicle_sales_management.model.cars;

public interface VehicleFactory {
    public Vehicle createCar();
    public Vehicle createTruck();
    public Vehicle createMotorcycle();
}
