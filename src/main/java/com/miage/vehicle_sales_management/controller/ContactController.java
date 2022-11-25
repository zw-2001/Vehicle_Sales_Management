package com.miage.vehicle_sales_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @RequestMapping(value = "/contact")
    public ModelAndView contact(ModelAndView mv) {
        mv.setViewName("contact");
        return mv;
    }
}
