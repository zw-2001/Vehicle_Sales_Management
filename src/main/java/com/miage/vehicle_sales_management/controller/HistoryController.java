package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class HistoryController {
    User user = User.getInstance();

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public ModelAndView history(ModelAndView mv) {
        mv.addObject("user", user.getType());
        mv.setViewName("history");
        return mv;
    }
}
