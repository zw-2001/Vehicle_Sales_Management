package com.miage.vehicle_sales_management.entities.cars;

public class ThermalVehicleFactory implements VehicleFactory {

    @Override
    public Car createCar() {
        return new ThermalCar();
    }

    @Override
    public Truck createTruck() {
        return new ThermalTruck();
    }

    @Override
    public Motorcycle createMotorcycle() {
        return new ThermalMotorcycle();
    }
}
