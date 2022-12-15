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

import java.security.NoSuchAlgorithmException;

/**
 * Controller related to the user
 */
@Controller
@SessionAttributes("user")
public class UserController {

    /**
     * Show the login page of the website
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page login.jsp
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("user", user.getType());
        mv.setViewName("login");
        return mv;
    }

    /**
     * Check the user's credentials
     * If the credentials are correct, the user is redirected to the page catalog.jsp
     * If the credentials are incorrect or user does not exist in the database, the page login.jsp is displayed again with an error message
     *
     * @param email    Email of the user
     * @param password Password of the user
     * @param mv       ModelAndView of the page
     * @return mv ModelAndView with the page catalog.jsp or login.jsp
     */
    @RequestMapping(value = "/login-check", method = RequestMethod.POST)
    public ModelAndView loginCheck(@RequestParam("email") String email, @RequestParam("password") String password,
                                   ModelAndView mv) throws NoSuchAlgorithmException {
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

    /**
     * Show the register page of the website
     *
     * @param mv ModelAndView of the page
     * @return mv ModelAndView with the page register.jsp
     */
    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView register(ModelAndView mv) {
        User user = User.getInstance();
        mv.addObject("user", user.getType());
        mv.setViewName("register");
        return mv;
    }

    /**
     * Register a new user and check if the email is already used
     * If the registration is successful, the user is redirected to the page catalog.jsp
     * If the registration is unsuccessful, the page register.jsp is displayed again with an error message
     *
     * @param email    Email of the user
     * @param password Password of the user
     * @param mv       ModelAndView of the page
     * @return mv ModelAndView with the page catalog.jsp or register.jsp
     */
    @RequestMapping(value = "/register-check", method = RequestMethod.POST)
    public ModelAndView registerCheck(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName,
                                      @RequestParam("type") String type, @RequestParam("email") String email,
                                      @RequestParam("password") String password,
                                      @RequestParam("country") String country, ModelAndView mv) throws NoSuchAlgorithmException {
        int register = new UserDao().registerUser(type, email, password, lastName, firstName, country);

        if (register != 0) {
            mv.addObject("user", User.getInstance().getType());
            mv.setViewName("redirect:/catalog");
        } else {
            mv.addObject("msg", "Une erreur est survenue lors de l'inscription. Veuillez réessayer.");
            mv.setViewName("register");
        }
        return mv;
    }

    /**
     * Disconnect the user and redirect to the page login.jsp
     *
     * @param mv     ModelAndView of the page
     * @param status SessionStatus of the user
     * @return mv ModelAndView with the page login.jsp
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout(ModelAndView mv, SessionStatus status) {
        User.getInstance().logout();
        status.setComplete();
        mv.addObject("user", User.getInstance().getType());
        mv.setViewName("index");
        return mv;
    }
}
