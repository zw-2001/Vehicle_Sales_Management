package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.HistoryDao;
import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class HistoryController {

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public ModelAndView history(ModelAndView mv) {
        HistoryDao historyDao = new HistoryDao();
        int history;
        if (User.getInstance().getType().equals("Administrator")) {
            history = historyDao.showHistoryAdmin();
        }
        else {
            history = historyDao.showHistory();
        }
        if (history != 0) {
            if (User.getInstance().getInvoices().size() != 0) {
                mv.addObject("invoices", User.getInstance().getInvoices());
            }
            else {
                mv.addObject("msg", "Historique vide.");
            }
        }
        else {
            mv.addObject("msg", "Erreur lors de l'affichage de l'historique. Veuillez réessayer.");
        }
        mv.setViewName("history");
        return mv;
    }
}
