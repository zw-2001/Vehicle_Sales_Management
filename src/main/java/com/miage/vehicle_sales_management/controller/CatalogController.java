package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.CatalogDao;
import com.miage.vehicle_sales_management.model.shop.Catalog;
import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class CatalogController {
    User user = User.getInstance();

    @RequestMapping(value = "/catalog")
    public ModelAndView catalog(ModelAndView mv) {
        mv.addObject("user", user.getType());
        int catalog = new CatalogDao().showCatalog();
        if (catalog != 0) {
            mv.addObject("vehicles", Catalog.getInstance().getVehicles());
        } else {
            mv.addObject("msg", "Catalogue vide.");
        }
        mv.setViewName("catalog");
        return mv;
    }

    // TODO
    @RequestMapping(value = "/management", method = RequestMethod.POST)
    public ModelAndView management(ModelAndView mv, @RequestParam("action") String action) {
        // Appel DAO pour management et String sql avec if en fonction de action
        System.out.println(action);
        mv.addObject("user", user.getType());
        //mv.setViewName("management");
        return mv;
    }
}
