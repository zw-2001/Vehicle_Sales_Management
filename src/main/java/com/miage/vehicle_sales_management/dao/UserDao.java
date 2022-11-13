package com.miage.vehicle_sales_management.dao;


import com.miage.vehicle_sales_management.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection con = ConnectionManager.getConnection();
    public int registerUser(String email, String password, String lastName, String firstName) {
        String sql = "INSERT INTO users (Email, Password, LastName, FirstName) VALUES (?, ?, ?, ?)";

        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                ps.setString(3, lastName);
                ps.setString(4, firstName);
                ps.executeUpdate();
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int loginUser(String email, String password) {
        String sql = "SELECT * FROM Users WHERE Email = ? AND Password = ?";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User user = User.getInstance();
                    user.setUserId(rs.getInt("ID_User"));
                    user.setEmail(rs.getString("Email"));
                    user.setPassword(rs.getString("Password"));
                    user.setLastName(rs.getString("LastName"));
                    user.setFirstName(rs.getString("FirstName"));
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}