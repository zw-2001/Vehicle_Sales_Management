package com.miage.vehicle_sales_management.model.shop;

import com.miage.vehicle_sales_management.model.vehicles.Vehicle;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {

    public static Cart instance;

    private ArrayList<Vehicle> vehicles;

    private int InvoiceId;
    private boolean payment;
    private float total;

    public Cart() {
        this.vehicles = new ArrayList<>();
        this.payment = false;
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
        this.InvoiceId = 0;
        this.payment = false;
        this.total = 0;
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

    public boolean getPayment() {
        return payment;
    }
    public void setPayment(boolean payment) {
        this.payment = payment;
    }
}
