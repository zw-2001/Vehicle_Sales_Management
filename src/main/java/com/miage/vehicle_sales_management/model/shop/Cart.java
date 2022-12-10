package com.miage.vehicle_sales_management.model.shop;

import com.miage.vehicle_sales_management.model.cars.Vehicle;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {

    public static Cart instance;

    private ArrayList<Vehicle> vehicles;

    private int InvoiceId;
    private float total;

    public Cart() {
        this.vehicles = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle, int quantity) {
        vehicle.setQuantity(quantity);
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void clearCart() {
        this.vehicles.clear();
    }

    public int getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        InvoiceId = invoiceId;
    }

    public String getTotal() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(total);
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
