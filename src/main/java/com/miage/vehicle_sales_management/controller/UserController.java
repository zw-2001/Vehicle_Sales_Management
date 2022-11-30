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
    User user = User.getInstance();
    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView mv) {
        mv.addObject("user", user.getType());
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping(value = "/login-check", method = RequestMethod.POST)
    public ModelAndView userLoginCheck(@RequestParam("email") String email, @RequestParam("password") String password, ModelAndView mv) {
        int login = new UserDao().loginUser(email, password);

        if (login != 0) {
            User user = User.getInstance();
            mv.addObject("user", user.getType());
            mv.addObject("msg", "Bonjour " + user.getFirstName() + " !");
        } else {
            mv.addObject("msg", "Email ou mot de passe invalide. Veuillez réessayer.");
        }
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "/signup")
    public ModelAndView signup(ModelAndView mv) {
        mv.addObject("user", user.getType());
        mv.setViewName("signup");
        return mv;
    }

/*    @RequestMapping(value = "/signup-check", method = RequestMethod.POST)
    public ModelAndView userSignupCheck(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName, ModelAndView mv) {

        int signup = new UserDao().signupUser(email, password, lastName, firstName);

        if (signup != 0) {
            User user = User.getInstance();
            mv.addObject("msg", "Welcome " + user.getEmail() + ", You have successfully signed up.");
            mv.setViewName("welcome");
        } else {
            mv.addObject("msg", "Invalid email or password.");
            mv.setViewName("index");
        }
        return mv;
    }*/

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(ModelAndView mv, SessionStatus status) {
        User user = User.getInstance();
        status.setComplete();
        user.logout();
        mv.addObject("user", user.getType());
        mv.setViewName("index");
        return mv;
    }
}
