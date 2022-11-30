package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.cars.Vehicle;
import com.miage.vehicle_sales_management.model.shop.Catalog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CatalogDao {

    private Connection con = ConnectionManager.getConnection();

    public int showCatalog() {
        String sql = "SELECT * FROM Vehicle";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                Catalog catalog = Catalog.getInstance();
                catalog.clearCatalog();
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle(
                            rs.getInt("Id_Vehicle"),
                            rs.getString("Vehicle"),
                            rs.getString("Type"),
                            rs.getString("Brand"),
                            rs.getFloat("Price"),
                            rs.getString("Energy"),
                            rs.getString("Gearbox"),
                            rs.getString("Seat"),
                            rs.getString("Image")
                    );
                    catalog.addVehicle(vehicle);
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
