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
@SessionAttributes("user")
public class UserController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("user", user.getType());
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/login-check", method = RequestMethod.POST)
    public ModelAndView loginCheck(@RequestParam("email") String email, @RequestParam("password") String password, ModelAndView mv) {
        User user = User.getInstance();
        int login = new UserDao().loginUser(email, password);

        if (login != 0) {
            mv.addObject("user", user.getType());
            mv.setViewName("redirect:/catalog");
        } else {
            mv.addObject("msg", "Email ou mot de passe invalide. Veuillez réessayer.");
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView signup(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("user", user.getType());
        mv.setViewName("signup");
        return mv;
    }

    @RequestMapping(value = "/signup-check", method = RequestMethod.POST)
    public ModelAndView signupCheck(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName, @RequestParam("type") String type, @RequestParam("email") String email, @RequestParam("password") String password, ModelAndView mv) {
        int signup = new UserDao().signupUser(type, email, password, lastName, firstName);

        if (signup != 0) {
            mv.addObject("user", User.getInstance().getType());
            mv.setViewName("redirect:/catalog");
        } else {
            mv.addObject("msg", "Un compte associé à cette adresse email existe déjà.");
            mv.setViewName("signup");
        }
        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(ModelAndView mv, SessionStatus status) {
        User.getInstance().logout();
        status.setComplete();
        mv.addObject("user", User.getInstance().getType());
        mv.setViewName("index");
        return mv;
    }
}
