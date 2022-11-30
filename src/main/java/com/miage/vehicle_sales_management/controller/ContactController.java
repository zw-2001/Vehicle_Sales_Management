package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class ContactController {
    User user = User.getInstance();

    @RequestMapping(value = "/contact")
    public ModelAndView contact(ModelAndView mv) {
        mv.addObject("user", user.getType());
        mv.setViewName("contact");
        return mv;
    }
}
