package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.cars.Vehicle;
import com.miage.vehicle_sales_management.model.shop.Catalog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CatalogDao {
    private Connection con = ConnectionManager.getConnection();

    public int showCatalog() {
        String sql = "SELECT Vehicle.Id_Vehicle AS Id_Vehicle, Vehicle, Type, Brand, Vehicle.Price AS Price, Energy, " +
                "Gearbox, Seat, Image, SUM(Quantity) AS Stock, MIN(AcquisitionDate) AS AcquisitionDate " +
                "FROM Vehicle, Stock " +
                "WHERE Vehicle.Id_Vehicle = Stock.Id_Vehicle " +
                "AND Stock.Quantity > 0 " +
                "GROUP BY Vehicle.Id_Vehicle;";
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
                            rs.getString("Image"),
                            rs.getInt("Stock"),
                            rs.getDate("AcquisitionDate")
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
