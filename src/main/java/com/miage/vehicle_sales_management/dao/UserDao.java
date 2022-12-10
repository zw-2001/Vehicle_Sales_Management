package com.miage.vehicle_sales_management.dao;


import com.miage.vehicle_sales_management.model.users.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection con = ConnectionManager.getConnection();

    public int loginUser(String email, String password) {
        String sql = "SELECT * FROM User WHERE Email = ? AND Password = ?";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User user = User.getInstance();
                    user.setId(rs.getInt("Id_User"));
                    user.setType(rs.getString("Type"));
                    user.setEmail(rs.getString("Email"));
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

    public int signupUser(String type, String email, String password, String lastName, String firstName) throws NoSuchAlgorithmException {
        String sql = "INSERT INTO User (Type, Email, Password, LastName, FirstName) VALUES (?, ?, ?, ?, ?)";

        if (con != null) {
            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            byte[] result = md.digest(password.getBytes());
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, type);
                ps.setString(2, email);
                ps.setString(3, String.valueOf(result));
                ps.setString(4, lastName);
                ps.setString(5, firstName);
                ps.executeUpdate();

                // login after successfully signed up
                try {
                    loginUser(email, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}