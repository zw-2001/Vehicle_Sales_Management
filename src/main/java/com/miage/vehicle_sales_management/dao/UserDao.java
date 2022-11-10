package com.miage.vehicle_sales_management.dao;


import com.miage.vehicle_sales_management.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection con = ConnectionManager.getConnection();
    public int registerUser(User user) {
        String sql = "INSERT INTO users (Email, Password, LastName, FirstName, IS_Admin, IS_Company) VALUES (?, ?, ?, ?, ?, ?)";

        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getLastName());
                ps.setString(4, user.getFirstName());
                ps.setBoolean(5, user.isAdmin());
                ps.setBoolean(6, user.isCompany());
                ps.executeUpdate();
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int loginUser(User user) {
        String sql = "SELECT * FROM users WHERE Email = ? AND password = ?";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}