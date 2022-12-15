package com.miage.vehicle_sales_management.model.shop;

import com.miage.vehicle_sales_management.model.vehicles.Vehicle;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Class Cart to manage the cart of the user
 */
public class Cart {

    public static Cart instance;

    private ArrayList<Vehicle> vehicles;

    private int InvoiceId;
    private boolean payment;
    private float total;

    /**
     * Constructor of the class Cart
     */
    public Cart() {
        this.vehicles = new ArrayList<>();
        this.payment = false;
    }

    /**
     * Design pattern Singleton
     * Get the instance of the cart
     *
     * @return the instance of the cart
     */
    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    /**
     * Get the vehicles of the cart
     *
     * @return List of vehicles in the cart
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Add a vehicle to the cart
     *
     * @param vehicle  The vehicle to add
     * @param quantity The quantity of the vehicle to add
     */
    public void addVehicle(Vehicle vehicle, int quantity) {
        vehicle.setQuantity(quantity);
        this.vehicles.add(vehicle);
    }

    /**
     * Remove a vehicle from the cart
     *
     * @param vehicle The vehicle to remove
     */
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    /**
     * Clear the cart of the user
     */
    public void clearCart() {
        this.vehicles.clear();
        this.InvoiceId = 0;
        this.payment = false;
        this.total = 0;
    }

    /**
     * Get the invoice id of the cart
     *
     * @return the invoice id of the cart
     */
    public int getInvoiceId() {
        return InvoiceId;
    }

    /**
     * Set the invoice id of the cart
     *
     * @param invoiceId The invoice id of the cart
     */
    public void setInvoiceId(int invoiceId) {
        InvoiceId = invoiceId;
    }

    /**
     * Get the total price of the cart
     *
     * @return the total price of the cart
     */
    public String getTotal() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(total);
    }

    /**
     * Set the total price of the cart
     *
     * @param total The total price of the cart
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * Get the payment status of the cart
     *
     * @return the payment status of the cart
     */
    public boolean getPayment() {
        return payment;
    }

    /**
     * Set the payment status of the cart
     *
     * @param payment The payment status of the cart
     */
    public void setPayment(boolean payment) {
        this.payment = payment;
    }
}
