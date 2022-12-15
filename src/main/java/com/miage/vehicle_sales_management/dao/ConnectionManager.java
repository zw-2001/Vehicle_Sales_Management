package com.miage.vehicle_sales_management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to manage the connection to the database
 */
public class ConnectionManager {
    private static String url = "jdbc:mysql://localhost:3306/Vehicle_Sales_Management_DB";
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "password";
    private static Connection con;

    /**
     * Try to connect to the database
     * If the connection is successful, return the connection
     *
     * @return the connection to the database
     */
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
        return con;
    }
}
