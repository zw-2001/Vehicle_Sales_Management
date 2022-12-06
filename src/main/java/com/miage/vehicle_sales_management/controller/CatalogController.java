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

    @RequestMapping(value = "/catalog", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView catalog(ModelAndView mv) {
        User user = User.getInstance();
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
    public ModelAndView management(@RequestParam("quantity[]") int[] quantities,
                                   @RequestParam("checkbox[]") String[] checkboxes, ModelAndView mv) {
        if (checkboxes == null) {
            mv.addObject("msg", "Aucun véhicule sélectionné.");
        } else {
            CatalogDao catalog = new CatalogDao();
            if (catalog.deleteVehicles(quantities, checkboxes) != 0) {
                mv.addObject("msg", "Véhicule(s) supprimé(s) avec succès !");
            } else {
                mv.addObject("msg", "Une erreur s'est produite lors de la suppression " +
                        "du(es) véhicule(s). Veuillez réessayer.");
            }
        }
        mv.setViewName("catalog");
        return mv;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("search") String search, ModelAndView mv) {
        System.out.println(search);
        CatalogDao catalogDao = new CatalogDao();
        int searchResult = catalogDao.search(search);
        if (searchResult != 0) {
            Catalog catalog = Catalog.getInstance();
            if (catalog.getVehicles() != null) {
                mv.addObject("vehicles", catalog.getVehicles());
            } else {
                mv.addObject("msg", "Aucun résultat.");
            }
        } else {
            mv.addObject("msg", "Erreur lors de la recherche. Veuillez réessayer.");
        }
        mv.setViewName("catalog");
        return mv;
    }
}
