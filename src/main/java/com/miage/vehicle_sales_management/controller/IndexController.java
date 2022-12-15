package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller related to the index page (base controller)
 */
@Controller
@SessionAttributes("user")
public class IndexController {

    /**
     * Show the index page of the website
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page index.jsp
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("user", user.getType());
        mv.setViewName("index");
        return mv;
    }
}
