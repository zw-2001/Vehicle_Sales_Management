package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class ContactController {

    @RequestMapping(value = "/contact", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView contact(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("user", user.getType());
        mv.setViewName("contact");
        return mv;
    }
}
