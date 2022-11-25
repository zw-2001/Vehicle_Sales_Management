package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.UserDao;
import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("navbar")
public class LoginController {

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping(value = "/login-check", method = RequestMethod.POST)
    public ModelAndView userLoginCheck(@RequestParam("email") String email, @RequestParam("password") String password, ModelAndView mv) {

        int login = new UserDao().loginUser(email, password);

        if (login != 0) {
            User user = User.getInstance();
            mv.addObject("navbar", user.getType().toLowerCase());
            mv.setViewName("catalog");
        } else {
            mv.addObject("msg", "Email ou mot de passe invalide. Veuillez réessayer.");
            mv.setViewName("login");
        }
        return mv;
    }
}
