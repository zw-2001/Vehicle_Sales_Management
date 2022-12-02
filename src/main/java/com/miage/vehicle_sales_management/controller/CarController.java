package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.CarDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class CarController {

    @RequestMapping(value = "/add-car", method = RequestMethod.POST)
    public ModelAndView addCar(ModelAndView mv) {
        mv.setViewName("add-car");
        return mv;
    }

    // TODO
    @RequestMapping(value = "/add-car-check", method = RequestMethod.POST)
    public ModelAndView addCarCheck(ModelAndView mv) {

        int addCar = new CarDao().addCar();
        mv.addObject("msg", "Véhicule ajouté avec succès !");
        mv.setViewName("add-car");
        return mv;
    }
}
