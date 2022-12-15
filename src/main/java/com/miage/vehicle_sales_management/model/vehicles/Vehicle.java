package com.miage.vehicle_sales_management.model.vehicles;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 * Class Vehicle to manage the vehicles
 */
public class Vehicle {
    private int id;
    private String vehicle;
    private String type;
    private String brand;
    private float price;
    private String energy;
    private String gearbox;
    private String seat;
    private String image;
    private int quantity;
    private Date acquisitionDate;
    private float discount;

    /**
     * Constructor of the class Vehicle
     *
     * @param id              The id of the vehicle
     * @param vehicle         The vehicle
     * @param type            The type of the vehicle
     * @param brand           The brand of the vehicle
     * @param price           The price of the vehicle
     * @param energy          The energy of the vehicle
     * @param gearbox         The gearbox of the vehicle
     * @param seat            The seat of the vehicle
     * @param image           The image of the vehicle
     * @param quantity        The quantity of the vehicle
     * @param acquisitionDate The acquisition date of the vehicle
     * @param discount        The discount of the vehicle
     */
    public Vehicle(int id, String vehicle, String type, String brand, float price, String energy, String gearbox, String seat, String image, int quantity, Date acquisitionDate, float discount) {
        this.id = id;
        this.vehicle = vehicle;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.energy = energy;
        this.gearbox = gearbox;
        this.seat = seat;
        this.image = image;
        this.quantity = quantity;
        this.acquisitionDate = acquisitionDate;
        this.discount = discount;
    }

    /**
     * Get the id of the vehicle
     *
     * @return the id of the vehicle
     */
    public int getId() {
        return id;
    }

    /**
     * Get the vehicle
     *
     * @return the vehicle
     */
    public String getVehicle() {
        return vehicle;
    }

    /**
     * Get the type of the vehicle
     *
     * @return the type of the vehicle
     */
    public String getType() {
        return type;
    }

    /**
     * Get the brand of the vehicle
     *
     * @return the brand of the vehicle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Get the price of the vehicle
     *
     * @return the price of the vehicle
     */
    public String getPrice() {
        return getPrice(1);
    }

    /**
     * Set the price of the vehicle
     *
     * @param price The price of the vehicle
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Get the price of the vehicle
     *
     * @param quantity The quantity of the vehicle
     * @return the price of the vehicle
     */
    public String getPrice(int quantity) {
        if ((price * quantity) % 1 == 0) {
            return Integer.toString((int) (price * quantity));
        } else {
            DecimalFormat df = new DecimalFormat("#.00");
            return df.format((price * quantity));
        }
    }

    /**
     * Get the energy of the vehicle
     *
     * @return the energy of the vehicle
     */
    public String getEnergy() {
        return energy;
    }

    /**
     * Get the gearbox of the vehicle
     *
     * @return the gearbox of the vehicle
     */
    public String getGearbox() {
        return gearbox;
    }

    /**
     * Get the seat of the vehicle
     *
     * @return the seat of the vehicle
     */
    public String getSeat() {
        return seat;
    }

    /**
     * Get the image of the vehicle
     *
     * @return the image of the vehicle
     */
    public String getImage() {
        return image;
    }

    /**
     * Get the quantity of the vehicle
     *
     * @return the quantity of the vehicle
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the vehicle
     *
     * @param quantity The quantity of the vehicle
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the discount of the vehicle
     *
     * @return the discount of the vehicle
     */
    public float getDiscount() {
        return discount;
    }

    /**
     * Set the discount of the vehicle
     *
     * @param discount The discount of the vehicle
     */
    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
