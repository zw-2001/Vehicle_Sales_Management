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

/**
 * Controller related to the catalog management
 */
@Controller
@SessionAttributes("user")
public class CatalogController {

    /**
     * Show the catalog page of the website with all the vehicles available
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page catalog.jsp
     */
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

    /**
     * Manage the cars available in the catalog
     * If the action is delete, calling the model to delete the car in the database
     * If the action is cart, return the page to cart.jsp with all the cars in the cart
     *
     * @param action     The action to do
     * @param quantities Vehicles quantities array
     * @param checkboxes Vehicles id array
     * @param mv         ModelAndView of the page
     * @return mv ModelAndView with the page catalog.jsp or cart.jsp
     */
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

    /**
     * Show the cart page with all the vehicles in the cart
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page cart.jsp
     */
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

    /**
     * Clear the cart of the user
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page cart.jsp
     */
    @RequestMapping(value = "/clear-cart", method = RequestMethod.POST)
    public ModelAndView clearCart(ModelAndView mv) {
        User.getInstance().getCart().clearCart();
        mv.addObject("msg", "Votre panier a été vidé avec succès !");
        mv.setViewName("/cart");
        return mv;
    }

    /**
     * Filter the catalog with the user input from the search bar
     *
     * @param search Search input given by the user
     * @param mv     ModelAndView of the page
     * @return mv ModelAndView with the page catalog.jsp
     */
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

    /**
     * Create a new invoice with the vehicles in the cart
     * If the invoice is successfully generated, return the page invoice.jsp with the invoice details
     * If the invoice is not generated, return the page cart.jsp with the error message
     *
     * @param quantities Vehicles quantities array
     * @param checkboxes Vehicles id array
     * @param mv         ModelAndView of the page
     * @return mv ModelAndView with the page invoice.jsp or cart.jsp
     */
    @RequestMapping(value = "/invoice", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView invoice(@RequestParam("quantity[]") int[] quantities, @RequestParam("checkbox[]") int[] checkboxes, ModelAndView mv) {
        CatalogDao catalog = new CatalogDao();
        if (catalog.addVehiclesToCart(quantities, checkboxes) && catalog.getNextInvoiceId()) {
            setInvoiceInfo(mv);
            mv.setViewName("invoice");
        } else {
            mv.addObject("msg", "Une erreur s'est produite lors de la génération " +
                    "de la facture. Veuillez réessayer.");
            mv.setViewName("cart");
        }
        return mv;
    }

    /**
     * Set the invoice payment information and call the model to insert the invoice in the database
     *
     * @param payment The payment method chosen by the user
     * @param mv      ModelAndView of the page
     * @return mv ModelAndView with the page invoice.jsp
     */
    @RequestMapping(value = "/invoice-management", method = RequestMethod.POST)
    public ModelAndView invoiceManagement(@RequestParam("payment") String payment, ModelAndView mv) {
        if (payment.equals("cash") || payment.equals("credit3") || payment.equals("credit6") || payment.equals("credit12")) {
            CatalogDao catalog = new CatalogDao();
            if (catalog.payment(payment)) {
                mv.addObject("msg", "Véhicule(s) acheté(s) avec succès !");
            } else {
                mv.addObject("msg", "Une erreur s'est produite lors de l'achat " +
                        "du(es) véhicule(s). Veuillez réessayer.");
            }
            User.getInstance().getCart().setPayment(true);
            setInvoiceInfo(mv);
        } else {
            mv.addObject("msg", "Une erreur s'est produite lors de la confirmation " +
                    "de votre commande. Veuillez réessayer.");
        }
        mv.setViewName("invoice");
        return mv;
    }

    /**
     * Set the invoice information in the ModelAndView
     *
     * @param mv ModelAndView of the page
     */
    private void setInvoiceInfo(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("invoiceId", user.getCart().getInvoiceId());
        mv.addObject("invoicePayment", user.getCart().getPayment());
        mv.addObject("currentDate", LocalDate.now());
        mv.addObject("cartVehicles", user.getCart().getVehicles());
        mv.addObject("userAttribute", user);
        mv.addObject("total", user.getCart().getTotal());
    }
}
