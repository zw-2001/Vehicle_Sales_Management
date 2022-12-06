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

    public int deleteVehicles(int[] quantities, String[] checkboxes) {
        String sql = "UPDATE Stock SET Quantity = Quantity - ? WHERE Id_Vehicle = ?;";
        if (con != null) {
            try {
                for (int i = 0; i < checkboxes.length; i++) {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, quantities[i]);
                    ps.setInt(2, Integer.parseInt(checkboxes[i]));
                    ps.executeUpdate();
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int search(String search) {
        String sql = "SELECT Vehicle.Id_Vehicle AS Id_Vehicle, Vehicle, Type, Brand, Vehicle.Price AS Price, Energy, " +
                "Gearbox, Seat, Image, SUM(Quantity) AS Stock, MIN(AcquisitionDate) AS AcquisitionDate " +
                "FROM Vehicle, Stock " +
                "WHERE Vehicle.Id_Vehicle = Stock.Id_Vehicle " +
                "AND Stock.Quantity > 0 " +
                "AND (Vehicle LIKE ? OR Type LIKE ? OR Brand LIKE ? OR Energy LIKE ? OR Gearbox LIKE ? OR Seat LIKE ?) " +
                "GROUP BY Vehicle.Id_Vehicle;";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                ps.setString(2, "%" + search + "%");
                ps.setString(3, "%" + search + "%");
                ps.setString(4, "%" + search + "%");
                ps.setString(5, "%" + search + "%");
                ps.setString(6, "%" + search + "%");
                ResultSet rs = ps.executeQuery();
                Catalog catalog = Catalog.getInstance();
                catalog.clearCatalog();
                while (rs.next()) {
                    if (rs.getString("Vehicle").toLowerCase().contains(search.toLowerCase()) ||
                            rs.getString("Type").toLowerCase().contains(search.toLowerCase()) ||
                            rs.getString("Brand").toLowerCase().contains(search.toLowerCase()) ||
                            rs.getString("Energy").toLowerCase().contains(search.toLowerCase()) ||
                            rs.getString("Gearbox").toLowerCase().contains(search.toLowerCase()) ||
                            rs.getString("Seat").toLowerCase().contains(search.toLowerCase())) {
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
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
