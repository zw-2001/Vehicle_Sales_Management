package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class IndexController {
    User user = User.getInstance();
    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("user", user.getType());
        mv.setViewName("index");
        return mv;
    }
}
