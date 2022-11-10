package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    User user = User.getInstance();
    ModelAndView mv = new ModelAndView();

    @RequestMapping(value = "/")
    public String index() {
        switch (user.getRole()) {
            case "admin":
                return "redirect:/admin";
            case "seller":
                return "redirect:/seller";
            case "buyer":
                return "redirect:/buyer";
            case null:
                return "redirect:/login";
            default:
                return "index";
        }
    }
}
