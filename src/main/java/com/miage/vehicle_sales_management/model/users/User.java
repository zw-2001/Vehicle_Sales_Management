package com.miage.vehicle_sales_management.model.users;

import com.miage.vehicle_sales_management.dao.UserDao;

public class User {
    // Singleton pattern to ensure only one instance of User is created
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
