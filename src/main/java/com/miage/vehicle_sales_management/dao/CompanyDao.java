package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CompanyDao implements UserDao {

    @Override
    public int registerUser(User user) {
        String sql = "INSERT INTO company (company_id, password) VALUES (?, ?)";
        return 0;
    }

    @Override
    public String loginUser(User user) {
        return null;
    }
}
