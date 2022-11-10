package com.miage.vehicle_sales_management.model.users;

import com.miage.vehicle_sales_management.dao.UserDao;

public final class User {
    // Singleton pattern to ensure only one instance of User is created
    private static User instance = new User();
    private String username;
    private String password;
    private String role;

    private User() {

    }

    public static User getInstance() {
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
