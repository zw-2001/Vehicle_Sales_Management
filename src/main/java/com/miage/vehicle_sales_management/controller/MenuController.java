package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView mv) {
        User user = User.getInstance();
        switch ("admin") {
            case "admin" -> mv.addObject("navbar", "admin");
            case "company" -> mv.addObject("navbar", "company");
            case "individual" -> mv.addObject("navbar", "individual");
            default -> mv.addObject("navbar", "general");
        }
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/contact")
    public String contact() {
        return "contact";
    }
}
