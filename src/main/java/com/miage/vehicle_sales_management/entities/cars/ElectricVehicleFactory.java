package com.miage.vehicle_sales_management.entities.cars;

public class ElectricVehicleFactory implements VehicleFactory {

    @Override
    public Car createCar() {
        return new ElectricCar();
    }

    @Override
    public Truck createTruck() {
        return new ElectricTruck();
    }

    @Override
    public Motorcycle createMotorcycle() {
        return new ElectricMotorcycle();
    }
}
