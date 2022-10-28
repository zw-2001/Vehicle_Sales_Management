package com.miage.vehicle_sales_management.dao;


import com.miage.vehicle_sales_management.model.users.User;

import java.sql.Connection;

public interface UserDao {
    public int registerUser(User user);

    public String loginUser(User user);
}