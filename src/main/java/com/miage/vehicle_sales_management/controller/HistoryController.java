package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.HistoryDao;
import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

 /**
 * Controller related to the history page
 */
@Controller
@SessionAttributes("user")
public class HistoryController {

    /**
     * Show the history page and all the vehicles the user has purchased
     * If the user is an admin, the history of all the users is displayed
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page history.jsp
     */
    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public ModelAndView history(ModelAndView mv) {
        HistoryDao historyDao = new HistoryDao();
        boolean history;
        if (User.getInstance().getType().equals("Administrator")) {
            history = historyDao.showHistoryAdmin();
        } else {
            history = historyDao.showHistory();
        }
        if (history) {
            if (User.getInstance().getInvoices().size() != 0) {
                mv.addObject("invoices", User.getInstance().getInvoices());
            } else {
                mv.addObject("msg", "Historique vide.");
            }
        } else {
            mv.addObject("msg", "Erreur lors de l'affichage de l'historique. Veuillez réessayer.");
        }
        mv.setViewName("history");
        return mv;
    }
}
