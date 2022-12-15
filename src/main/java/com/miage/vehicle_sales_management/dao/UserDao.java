package com.miage.vehicle_sales_management.dao;


import com.miage.vehicle_sales_management.model.country.Country;
import com.miage.vehicle_sales_management.model.users.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Model of the user controller
 */
public class UserDao {
    private Connection con = ConnectionManager.getConnection();

    /**
     * Check if the user exists in the database
     *
     * @param email    The email of the user
     * @param password The password of the user
     * @return true if no errors occurred, false otherwise
     */
    public int loginUser(String email, String password) throws NoSuchAlgorithmException {
        String sql = "SELECT * FROM User, Country WHERE User.Id_Country = Country.Id_Country AND Email = ? AND Password = ?";
        if (con != null) {
            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            byte[] result = md.digest(password.getBytes());
            String hashedPassword = new String(result);
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, hashedPassword);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    User user = User.getInstance();
                    user.setId(rs.getInt("Id_User"));
                    user.setType(rs.getString("Type"));
                    user.setEmail(rs.getString("Email"));
                    user.setLastName(rs.getString("LastName"));
                    user.setFirstName(rs.getString("FirstName"));
                    user.setCountry(new Country(rs.getInt("Id_Country"), rs.getString("Name"), rs.getFloat("Tax") + 1));
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * Add a new user in the database
     *
     * @param type      The type of the user
     * @param email     The email of the user
     * @param password  The password of the user
     * @param lastName  The last name of the user
     * @param firstName The first name of the user
     * @param country   The country of the user
     * @return true if no errors occurred, false otherwise
     */
    public int registerUser(String type, String email, String password, String lastName, String firstName, String country) throws NoSuchAlgorithmException {
        String sql = "INSERT INTO User (Id_Country, Type, Email, Password, LastName, FirstName)\n" +
                "VALUES (\n" +
                "(SELECT Country.Id_Country\n" +
                "FROM Country\n" +
                "WHERE Country.Name = ?)\n" +
                ", ?, ?, ?, ?, ?)";

        if (con != null) {
            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            byte[] result = md.digest(password.getBytes());
            String hashedPassword = new String(result);
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, country);
                ps.setString(2, type);
                ps.setString(3, email);
                ps.setString(4, hashedPassword);
                ps.setString(5, lastName);
                ps.setString(6, firstName);
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