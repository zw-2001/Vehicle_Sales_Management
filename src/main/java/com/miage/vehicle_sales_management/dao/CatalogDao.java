package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.vehicles.Vehicle;
import com.miage.vehicle_sales_management.model.shop.Catalog;
import com.miage.vehicle_sales_management.model.users.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Model of the catalog controller
 */
public class CatalogDao {
    private Connection con = ConnectionManager.getConnection();

    /**
     * Get all the vehicles available in the database
     *
     * @return true if no errors occurred, false otherwise
     */
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
                return addVehiclesToCatalog(ps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Delete the selected vehicles from the database
     *
     * @param quantities Array of the quantities of the vehicles to delete
     * @param checkboxes Array of the vehicles id to delete
     * @return true if no errors occurred, false otherwise
     */
    public boolean deleteVehicles(int[] quantities, int[] checkboxes) {
        return updateStock(quantities, checkboxes);
    }

    /**
     * Get all the vehicles available in the database which match the search input given by the user
     *
     * @param search Search input given by the user
     * @return true if no errors occurred, false otherwise
     */
    public boolean search(String search) {
        List<String> searchList = Arrays.asList(search.toLowerCase().split(" "));
        String searchSql = "";
        // add new condition to the sql query if search contains "et" or "ou"
        if (searchList.contains("et") || searchList.contains("ou")) {
            for (int i = 0; i < searchList.size(); i++) {
                if (searchList.get(i).equals("et")) {
                    // the condition to add if there is "et" in the search input
                    searchSql += " AND (Vehicle LIKE ? OR Type LIKE ? OR Brand LIKE ? OR Energy LIKE ? OR Gearbox LIKE ? OR Seat LIKE ?)";
                } else if (searchList.get(i).equals("ou")) {
                    // the condition to add if there is "ou" in the search input
                    searchSql += " OR (Vehicle LIKE ? OR Type LIKE ? OR Brand LIKE ? OR Energy LIKE ? OR Gearbox LIKE ? OR Seat LIKE ?)";
                }
            }
        }
        searchSql += ") ";

        String sql = "SELECT Vehicle.Id_Vehicle AS Id_Vehicle, Vehicle, Type, Brand, Vehicle.Price AS Price, Energy, " +
                "Gearbox, Seat, Image, SUM(Quantity) AS Stock, MIN(AcquisitionDate) AS AcquisitionDate " +
                "FROM Vehicle, Stock " +
                "WHERE Vehicle.Id_Vehicle = Stock.Id_Vehicle " +
                "AND Stock.Quantity > 0 " +
                "AND ((Vehicle LIKE ? OR Type LIKE ? OR Brand LIKE ? OR Energy LIKE ? OR Gearbox LIKE ? OR Seat LIKE ?)" +
                searchSql + "GROUP BY Vehicle.Id_Vehicle;";
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
                return addVehiclesToCatalog(ps);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Add all the vehicles available in the database to the catalog
     * If the vehicle is difference between the current date and the acquisition date is more than 3 months, a discount of 10% is applied
     * If the user is a company, a discount of 5% is applied
     *
     * @param ps The PreparedStatement to execute
     * @return true if no errors occurred, false otherwise
     */
    private boolean addVehiclesToCatalog(PreparedStatement ps) throws SQLException {
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
                discount += 0.05;
            }
            User user = User.getInstance();
            float price = (1 - discount) * rs.getFloat("Price") * Float.parseFloat(user.getCountry().getTax().replace(',', '.'));
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

    /**
     * Update the stock of the vehicles
     *
     * @param vehicles List of the vehicles to update
     * @return true if no errors occurred, false otherwise
     */
    private boolean updateStock(ArrayList<Vehicle> vehicles) {
        int[] quantities = new int[vehicles.size()];
        int[] vehiclesId = new int[vehicles.size()];
        for (int i = 0; i < vehicles.size(); i++) {
            quantities[i] = vehicles.get(i).getQuantity();
            vehiclesId[i] = vehicles.get(i).getId();
        }
        return updateStock(quantities, vehiclesId);
    }

    /**
     * Update the stock of the vehicles
     *
     * @param quantities Array of the quantities of the vehicles to update
     * @param checkboxes Array of the vehicles id to update
     * @return true if no errors occurred, false otherwise
     */
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

    /**
     * Add the vehicles in the cart
     * If the number of one vehicle is greater than 20, a discount of 5% is applied
     *
     * @param quantities
     * @param checkboxes
     * @return
     */
    public boolean addVehiclesToCart(int[] quantities, int[] checkboxes) {
        try {
            User.getInstance().getCart().clearCart();
            float total = 0;
            for (Vehicle vehicle : Catalog.getInstance().getVehicles()) {
                for (int i = 0; i < checkboxes.length; i++) {
                    if (quantities[i] > 0 && vehicle.getId() == checkboxes[i]) {
                        if (quantities[i] > 20) {
                            float discount = (float) 0.05;
                            vehicle.setDiscount(vehicle.getDiscount() + discount);
                            vehicle.setPrice(Float.parseFloat(vehicle.getPrice().replace(',', '.')) * (1 - vehicle.getDiscount()));
                        }
                        User.getInstance().getCart().addVehicle(vehicle, quantities[i]);
                        total += Float.parseFloat(vehicle.getPrice().replace(',', '.')) * quantities[i];
                    }
                }
            }
            User.getInstance().getCart().setTotal(total);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Set the next invoice id of the table Invoice in the database
     *
     * @return true if no errors occurred, false otherwise
     */
    public boolean getNextInvoiceId() {
        String sql = "SELECT MAX(Id_Invoice) + 1 AS NEXT_ID\n" +
                "FROM   Invoice\n";

        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User.getInstance().getCart().setInvoiceId(rs.getInt("NEXT_ID"));
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Insert a new invoice in the database
     * Insert a new invoice detail for each vehicle in the cart
     *
     * @param payment The payment method of the invoice by the user
     * @return true if no errors occurred, false otherwise
     */
    public boolean payment(String payment) {
        String sql = "INSERT INTO Invoice (Id_User, Date, Payment, NbMonth, Total) VALUES (?, ?, ?, ?, ?);";
        String sql2 = "INSERT INTO InvoiceDetail (Id_Invoice, Id_Vehicle, Quantity, Total) VALUES (?, ?, ?, ?);";
        if (con != null) {
            try {
                User user = User.getInstance();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, user.getId());
                ps.setDate(2, Date.valueOf(LocalDate.now()));
                // set the variables of the payment method
                if (payment.equals("credit3")) {
                    ps.setString(3, "Credit");
                    ps.setInt(4, 3);
                } else if (payment.equals("credit6")) {
                    ps.setString(3, "Credit");
                    ps.setInt(4, 6);
                } else if (payment.equals("credit12")) {
                    ps.setString(3, "Credit");
                    ps.setInt(4, 12);
                } else {
                    ps.setString(3, "Cash");
                    ps.setInt(4, 0);
                }
                ps.setFloat(5, Float.parseFloat(user.getCart().getTotal().replace(',', '.')));
                ps.executeUpdate();
                for (Vehicle vehicle : Catalog.getInstance().getVehicles()) {
                    for (int i = 0; i < user.getCart().getVehicles().size(); i++) {
                        PreparedStatement ps2 = con.prepareStatement(sql2);
                        if (vehicle.getId() == user.getCart().getVehicles().get(i).getId()) {
                            ps2.setInt(1, user.getCart().getInvoiceId());
                            ps2.setInt(2, user.getCart().getVehicles().get(i).getId());
                            ps2.setInt(3, user.getCart().getVehicles().get(i).getQuantity());
                            ps2.setFloat(4, Float.parseFloat(vehicle.getPrice().replace(',', '.')) * user.getCart().getVehicles().get(i).getQuantity());
                            ps2.executeUpdate();
                        }

                    }
                }
                return updateStock(user.getCart().getVehicles());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
