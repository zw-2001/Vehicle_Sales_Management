package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.CarDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

/**
 * Controller related to the car management
 */
@Controller
@SessionAttributes("user")
public class CarController {

    /**
     * Show the add-car page of the website
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page add-car.jsp
     */
    @RequestMapping(value = "/add-car", method = RequestMethod.POST)
    public ModelAndView addCar(ModelAndView mv) {
        mv.setViewName("add-car");
        return mv;
    }

    /**
     * Check the car's information and call the model to add it in the database
     *
     * @param vehicle         Category of the vehicle
     * @param type            Type of the vehicle
     * @param brand           Brand of the vehicle
     * @param price           Price of the vehicle
     * @param energy          Energy of the vehicle
     * @param gearbox         Gearbox of the vehicle
     * @param seat            Number of seats of the vehicle
     * @param image           Image of the vehicle
     * @param quantity        Quantity of the vehicle
     * @param acquisitionDate Acquisition date of the vehicle
     * @param mv              ModelAndView of the page
     * @return mv ModelAndView with the page add-car.jsp
     */
    @RequestMapping(value = "/add-car-check", method = RequestMethod.POST)
    public ModelAndView addCarCheck(@RequestParam("Vehicle") String vehicle, @RequestParam("Type") String type, @RequestParam("Brand") String brand, @RequestParam("Price") float price, @RequestParam("Energy") String energy, @RequestParam("Gearbox") String gearbox, @RequestParam("Seat") String seat, @RequestParam("Image") String image, @RequestParam("Quantity") int quantity, @RequestParam("AcquisitionDate") Date acquisitionDate, ModelAndView mv) {
        boolean addCar = new CarDao().addCar(vehicle, type, brand, price, energy, gearbox, seat, image, quantity, acquisitionDate);
        if (addCar) {
            mv.addObject("msg", "Véhicule ajouté avec succès !");
        } else {
            mv.addObject("msg", "Une erreur s'est produite lors de l'ajout du véhicule. " + "Veuillez réessayer.");
        }
        mv.setViewName("add-car");
        return mv;
    }
}
