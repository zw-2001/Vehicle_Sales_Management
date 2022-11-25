package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("navbar")
public class LogoutController {

    @RequestMapping(value = "/logout")
    public ModelAndView logout(ModelAndView mv) {
        User user = User.getInstance();
        user.logout();
        mv.addObject("navbar", user.getType().toLowerCase());
        mv.setViewName("index");
        return mv;
    }
}
