package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String index() {
        System.out.println("testTest");
        return "test";
    }
}
