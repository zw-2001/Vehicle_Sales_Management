package com.miage.vehicle_sales_management.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 * Model of the car controller
 */
public class CarDao {
    private Connection con = ConnectionManager.getConnection();

    /**
     * Add a car in the database
     *
     * @param vehicle         Category of the vehicle
     * @param type            Type of the vehicle
     * @param brand           Brand of the vehicle
     * @param price           Price of the vehicle
     * @param energy          Energy of the vehicle
     * @param gearbox         Gearbox of the vehicle
     * @param seat            Number of seats of the vehicle
     * @param image           Image of the vehicle
     * @param quantity        Quantity of the vehicle
     * @param acquisitionDate Acquisition date of the vehicle
     * @return true if the car is added, false if not
     */
    public boolean addCar(String vehicle, String type, String brand, float price, String energy, String gearbox,
                      String seat, String image, int quantity, Date acquisitionDate) {
        String sql = "INSERT INTO Vehicle (Vehicle, Type, Brand, Price, Energy, Gearbox, Seat, Image) VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";
        String sql2 = "INSERT INTO Stock (Id_Vehicle, Quantity, AcquisitionDate) VALUES (LAST_INSERT_ID(), ?, ?);";

        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, vehicle);
                ps.setString(2, type);
                ps.setString(3, brand);
                ps.setFloat(4, price);
                ps.setString(5, energy);
                ps.setString(6, gearbox);
                ps.setString(7, seat);
                ps.setString(8, image);
                ps.executeUpdate();
                ps = con.prepareStatement(sql2);
                ps.setInt(1, quantity);
                ps.setDate(2, acquisitionDate);
                ps.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
