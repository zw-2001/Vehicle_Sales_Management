package com.miage.vehicle_sales_management.model.country;

import java.text.DecimalFormat;

/**
 * Class Country to manage the country of the user
 */
public class Country {
    private int id;
    private String name;
    private float tax;

    /**
     * Constructor of the class Country
     *
     * @param id   The id of the country
     * @param name The name of the country
     * @param tax  The tax of the country
     */
    public Country(int id, String name, float tax) {
        this.id = id;
        this.name = name;
        this.tax = tax;
    }

    /**
     * Get the tax of the country
     *
     * @return the tax of the country
     */
    public String getTax() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format((1 + ((tax + 10) / 100)));
    }
}
