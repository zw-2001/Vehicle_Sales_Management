package com.miage.vehicle_sales_management.model.documents;

import com.miage.vehicle_sales_management.model.vehicles.Vehicle;

import java.math.BigDecimal;

/**
 * Class InvoiceDetail to manage the details of the invoices
 */
public class InvoiceDetail {
    private Vehicle vehicle;
    private int quantity;
    private BigDecimal total;

    /**
     * Constructor of the class InvoiceDetail
     *
     * @param vehicle  The vehicle of the invoice detail
     * @param quantity The quantity of the invoice detail
     * @param total    The total of the invoice detail
     */
    public InvoiceDetail(Vehicle vehicle, int quantity, BigDecimal total) {
        this.vehicle = vehicle;
        this.quantity = quantity;
        this.total = total;
    }

    /**
     * Get the vehicle of the invoice detail
     *
     * @return the vehicle of the invoice detail
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Get the vehicle quantity of the invoice detail
     *
     * @return the vehicle quantity of the invoice detail
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get the total price of the invoice detail for the vehicle
     *
     * @return the total price of the invoice detail for the vehicle
     */
    public BigDecimal getTotal() {
        return total;
    }
}
