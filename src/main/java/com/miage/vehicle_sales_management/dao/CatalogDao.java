package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.cars.Vehicle;
import com.miage.vehicle_sales_management.model.shop.Catalog;
import com.miage.vehicle_sales_management.model.users.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CatalogDao {
    private Connection con = ConnectionManager.getConnection();

    public boolean showCatalog() {
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
        return false;
    }

    public boolean deleteVehicles(int[] quantities, int[] checkboxes) {
        return updateStock(quantities, checkboxes);
    }

    public boolean search(String search) {
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
        return false;
    }

    private boolean addCarsToCatalog(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        Catalog catalog = Catalog.getInstance();
        catalog.clearCatalog();
        LocalDate date = LocalDate.now();
        Date sqlDate = Date.valueOf(date.minusYears(1));
        while (rs.next()) {
            float discount = 0;
            if (rs.getDate("AcquisitionDate").compareTo(sqlDate) < 0) {
                discount += 0.1;
            }
            if (User.getInstance().getType().equals("Company")) {
                discount += 0.1;
            }
            float price = (1 - discount) * rs.getFloat("Price");
            Vehicle vehicle = new Vehicle(
                    rs.getInt("Id_Vehicle"),
                    rs.getString("Vehicle"),
                    rs.getString("Type"),
                    rs.getString("Brand"),
                    price,
                    rs.getString("Energy"),
                    rs.getString("Gearbox"),
                    rs.getString("Seat"),
                    rs.getString("Image"),
                    rs.getInt("Stock"),
                    rs.getDate("AcquisitionDate"),
                    discount

            );
            catalog.addVehicle(vehicle);
        }
        return true;
    }

    /*public boolean confirmBuyVehicles(int[] quantities, int[] checkboxes, String payment) {
        String sql = "INSERT INTO Invoice (Id_Invoice, Id_User, Date, Payment, NbMonth, Total) VALUES (?, ?, ?, ?, ?, ?);";

        return updateStock(quantities, checkboxes);
    }*/

    private boolean updateStock(int[] quantities, int[] checkboxes) {
        String sql = "UPDATE Stock SET Quantity = Quantity - ? WHERE Id_Vehicle = ?;";
        if (con != null) {
            try {
                for (int i = 0; i < checkboxes.length; i++) {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, quantities[i]);
                    ps.setInt(2, checkboxes[i]);
                    ps.executeUpdate();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean addVehiclesToCart(int[] quantities, int[] checkboxes) {
        try {
            for (Vehicle vehicle : Catalog.getInstance().getVehicles()) {
                for (int i = 0; i < quantities.length; i++) {
                    if (quantities[i] > 0 && vehicle.getId() == checkboxes[i]) {
                        User.getInstance().getCart().addVehicle(vehicle, quantities[i]);
                    }
                }
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
