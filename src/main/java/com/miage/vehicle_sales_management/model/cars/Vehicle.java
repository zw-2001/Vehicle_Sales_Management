package com.miage.vehicle_sales_management.model.cars;

import java.time.LocalDate;
import java.sql.Date;
import java.text.DecimalFormat;

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

    public Vehicle(int id, String vehicle, String type, String brand, float price, String energy, String gearBox, String seat, String image, int quantity, Date acquisitionDate, float discount) {
        this.id = id;
        this.vehicle = vehicle;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.energy = energy;
        this.gearbox = gearBox;
        this.seat = seat;
        this.image = image;
        this.quantity = quantity;
        this.acquisitionDate = acquisitionDate;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public Object getPrice() {
        if (price % 1 == 0) {
            return (int) price;
        } else {
            DecimalFormat df = new DecimalFormat("#.00");
            return df.format(price);
        }
    }

    public String getEnergy() {
        return energy;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getSeat() {
        return seat;
    }

    public String getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
