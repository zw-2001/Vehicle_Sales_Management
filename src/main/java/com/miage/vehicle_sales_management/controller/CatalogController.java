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

import java.time.LocalDate;

@Controller
@SessionAttributes("user")
public class CatalogController {

    @RequestMapping(value = "/catalog", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView catalog(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("user", user.getType());
        boolean catalog = new CatalogDao().showCatalog();
        if (catalog) {
            mv.addObject("vehicles", Catalog.getInstance().getVehicles());
        } else {
            mv.addObject("msg", "Catalogue vide.");
        }
        mv.setViewName("catalog");
        return mv;
    }

    @RequestMapping(value = "/management", method = RequestMethod.POST)
    public ModelAndView management(@RequestParam("action") String action,
                                   @RequestParam("quantity[]") int[] quantities,
                                   @RequestParam("checkbox[]") int[] checkboxes, ModelAndView mv) {
        mv.setViewName("catalog");
        CatalogDao catalog = new CatalogDao();
        if (action.equals("delete")) {
            if (catalog.deleteVehicles(quantities, checkboxes)) {
                mv.addObject("msg", "Véhicule(s) supprimé(s) avec succès !");
            } else {
                mv.addObject("msg", "Une erreur s'est produite lors de la suppression " +
                        "du(es) véhicule(s). Veuillez réessayer.");
            }
        } else if (action.equals("cart")) {
            if (catalog.addVehiclesToCart(quantities, checkboxes)) {
                mv.setViewName("redirect:/cart");
            } else {
                mv.addObject("msg", "Une erreur s'est produite lors de l'ajout " +
                        "du(es) véhicule(s) au panier. Veuillez réessayer.");
            }
        } else {
            mv.addObject("msg", "Une erreur s'est produite. Veuillez réessayer.");
        }

        return mv;
    }

    @RequestMapping(value = "/cart", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView cart(ModelAndView mv) {
        User user = User.getInstance();
        if (user.getCart().getVehicles().isEmpty()) {
            mv.addObject("msg", "Votre panier est vide.");
        } else {
            mv.addObject("cartVehicles", user.getCart().getVehicles());
        }
        mv.setViewName("cart");
        return mv;
    }

    @RequestMapping(value = "/clear-cart", method = RequestMethod.POST)
    public ModelAndView clearCart(ModelAndView mv) {
        User.getInstance().getCart().clearCart();
        mv.addObject("msg", "Votre panier a été vidé avec succès !");
        mv.setViewName("/cart");
        return mv;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("search") String search, ModelAndView mv) {
        CatalogDao catalogDao = new CatalogDao();
        if (catalogDao.search(search)) {
            Catalog catalog = Catalog.getInstance();
            if (catalog.getVehicles().size() != 0) {
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

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public ModelAndView invoice(@RequestParam("quantity[]") int[] quantities, @RequestParam("checkbox[]") int[] checkboxes, ModelAndView mv) {
        CatalogDao catalog = new CatalogDao();
        if (catalog.addVehiclesToCart(quantities, checkboxes) && catalog.getNextInvoiceId()) {
            User user = User.getInstance();
            mv.addObject("invoiceId", user.getCart().getInvoiceId());
            mv.addObject("currentDate", LocalDate.now());
            mv.addObject("cartVehicles", user.getCart().getVehicles());
            mv.addObject("userAttribute", user);
            mv.addObject("total", user.getCart().getTotal());
            mv.setViewName("invoice");
        } else {
            mv.addObject("msg", "Une erreur s'est produite lors de la génération " +
                    "de la facture. Veuillez réessayer.");
            mv.setViewName("cart");
        }
        return mv;
    }

/*    @RequestMapping(value = "/buy-confirmation", method = RequestMethod.POST)
    public ModelAndView buyConfirmation(@RequestParam("payment") String payment,
                                        @RequestParam("quantity[]") int[] quantities,
                                        @RequestParam("checkbox[]") int[] checkboxes, ModelAndView mv) {
        if (payment.equals("cash") || payment.equals("credit")) {
            CatalogDao catalog = new CatalogDao();
            if (catalog.confirmBuyVehicles(quantities, checkboxes, payment)) {
                mv.addObject("msg", "Véhicule(s) acheté(s) avec succès !");
            } else {
                mv.addObject("msg", "Une erreur s'est produite lors de l'achat " +
                        "du(es) véhicule(s). Veuillez réessayer.");
            }
        } else {
            mv.addObject("msg", "Une erreur s'est produite lors de la confirmation " +
                    "de votre commande. Veuillez réessayer.");
        }
        return mv;
    }*/
}
