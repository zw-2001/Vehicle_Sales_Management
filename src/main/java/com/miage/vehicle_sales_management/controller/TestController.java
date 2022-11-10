package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    User user = User.getInstance();
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String index() {
        return "test";
    }
}
