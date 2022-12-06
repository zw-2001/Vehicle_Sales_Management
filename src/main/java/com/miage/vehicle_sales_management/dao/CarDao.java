package com.miage.vehicle_sales_management.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class CarDao {
    private Connection con = ConnectionManager.getConnection();

    public int addCar(String vehicle, String type, String brand, float price, String energy, String gearbox,
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
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, quantity);
                ps2.setDate(2, acquisitionDate);
                ps2.executeUpdate();
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
