package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.cars.Vehicle;
import com.miage.vehicle_sales_management.model.shop.Catalog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
                return addCarsToCatalog(ps);
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
        List<String> searchList = Arrays.asList(search.toLowerCase().split(" "));
        String searchSql = "";
        if (searchList.contains("et") || searchList.contains("ou")) {
            for (int i = 0; i < searchList.size(); i++) {
                if (searchList.get(i).equals("et")) {
                    searchSql += " AND (Vehicle LIKE ? OR Type LIKE ? OR Brand LIKE ? OR Energy LIKE ? OR Gearbox LIKE ? OR Seat LIKE ?)";
                } else if (searchList.get(i).equals("ou")) {
                    searchSql += " OR (Vehicle LIKE ? OR Type LIKE ? OR Brand LIKE ? OR Energy LIKE ? OR Gearbox LIKE ? OR Seat LIKE ?)";
                }
            }
        }
        searchSql += ") ";

        String sql = "SELECT Vehicle.Id_Vehicle AS Id_Vehicle, Vehicle, Type, Brand, Vehicle.Price AS Price, Energy, Gearbox, Seat, Image, SUM(Quantity) AS Stock, MIN(AcquisitionDate) AS AcquisitionDate FROM Vehicle, Stock WHERE Vehicle.Id_Vehicle = Stock.Id_Vehicle AND Stock.Quantity > 0 AND ((Vehicle LIKE ? OR Type LIKE ? OR Brand LIKE ? OR Energy LIKE ? OR Gearbox LIKE ? OR Seat LIKE ?)" + searchSql + "GROUP BY Vehicle.Id_Vehicle;";
        System.out.println(sql);
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                for (int i = 0; i < 6; i++) {
                    ps.setString(i + 1, "%" + searchList.get(0) + "%");
                }
                if (searchList.contains("et") || searchList.contains("ou")) {
                    int i = 7;
                    for (int j = 0; j < searchList.size(); j++) {
                        if (searchList.get(j).equals("et") || searchList.get(j).equals("ou")) {
                            for (int k = i; k < (i + 6); k++) {
                                ps.setString(k, "%" + searchList.get(j + 1) + "%");
                            }
                            i += 6;
                        }
                    }
                }
                return addCarsToCatalog(ps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private int addCarsToCatalog(PreparedStatement ps) throws SQLException {
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
    }
}
