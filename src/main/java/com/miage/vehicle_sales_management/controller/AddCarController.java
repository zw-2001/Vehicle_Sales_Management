package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class AddCarController {

    User user = User.getInstance();

    @RequestMapping(value = "/add-car", method = RequestMethod.POST)
    public ModelAndView addCar(ModelAndView mv) {
        mv.addObject("user", user.getType());
        mv.setViewName("add-car");
        return mv;
    }

    // TODO
    @RequestMapping(value = "/add-car-check", method = RequestMethod.POST)
    public ModelAndView addCarCheck(ModelAndView mv) {
        mv.addObject("user", user.getType());
        mv.addObject("msg", "Véhicule ajouté avec succès !");
        mv.setViewName("add-car");
        return mv;
    }
}
