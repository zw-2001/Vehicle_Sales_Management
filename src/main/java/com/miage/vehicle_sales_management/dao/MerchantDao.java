package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.users.User;

public class MerchantDao implements UserDao {

    @Override
    public int registerUser(User user) {
        return 0;
    }

    @Override
    public String loginUser(User user) {
        return null;
    }
}
