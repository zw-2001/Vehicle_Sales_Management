package com.miage.vehicle_sales_management.model.country;

import java.text.DecimalFormat;

public class Country {
    private int id;
    private String name;
    private float tax;

    public Country(int id, String name, float tax) {
        this.id = id;
        this.name = name;
        this.tax = tax;
    }

    public String getTax() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format((1 + ((tax + 10) / 100)));
    }
}
