package com.miage.vehicle_sales_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogController {

    @RequestMapping(value = "/catalog")
    public ModelAndView catalog(ModelAndView mv) {
        mv.setViewName("catalog");
        return mv;
    }
}
