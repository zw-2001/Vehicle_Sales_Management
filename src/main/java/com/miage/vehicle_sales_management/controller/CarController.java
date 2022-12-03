package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.CarDao;
import com.miage.vehicle_sales_management.model.cars.Vehicle;
import com.miage.vehicle_sales_management.model.shop.Catalog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;


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
    public ModelAndView addCarCheck(@RequestParam("Vehicle") String vehicle, @RequestParam("Type") String type,
                                    @RequestParam("Brand") String brand, @RequestParam("Price") float price,
                                    @RequestParam("Energy") String energy, @RequestParam("Gearbox") String gearbox,
                                    @RequestParam("Seat") String seat, @RequestParam("Image") String image,
                                    @RequestParam("Quantity") int quantity,
                                    @RequestParam("AcquisitionDate") Date acquisitionDate, ModelAndView mv) {
        int addCar = new CarDao().addCar(vehicle, type, brand, price, energy, gearbox, seat, image, quantity, acquisitionDate);
        if (addCar != 0) {
            mv.addObject("msg", "Véhicule ajouté avec succès !");
            Catalog catalog = Catalog.getInstance();
            catalog.addVehicle(new Vehicle(0, vehicle, type, brand, price, energy, gearbox, seat, image, quantity, acquisitionDate));
        } else {
            mv.addObject("msg", "Une erreur s'est produite lors de l'ajout du véhicule. " +
                    "Veuillez réessayer.");
        }
        mv.setViewName("add-car");
        return mv;
    }
}
