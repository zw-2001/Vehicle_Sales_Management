package com.miage.vehicle_sales_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarDao {
    private Connection con = ConnectionManager.getConnection();

    public int addCar() {
        String sql = "INSERT INTO Vehicle (Type, Brand, Price, Energy, Gearbox, Seat, Image) VALUES (?, ?, ?, ?, ?, ?, ?); " +
                "INSERT INTO Stock (Id_Vehicle, Quantity, AcquisitionDate) VALUES (LAST_INSERT_ID(), ?, ?);";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.executeUpdate();
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
