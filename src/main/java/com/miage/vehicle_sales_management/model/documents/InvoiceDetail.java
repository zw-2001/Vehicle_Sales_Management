package com.miage.vehicle_sales_management.model.documents;

import com.miage.vehicle_sales_management.model.vehicles.Vehicle;

import java.math.BigDecimal;

public class InvoiceDetail {
    private Vehicle vehicle;
    private int quantity;
    private BigDecimal total;

    public InvoiceDetail(Vehicle vehicle, int quantity, BigDecimal total) {
        this.vehicle = vehicle;
        this.quantity = quantity;
        this.total = total;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
