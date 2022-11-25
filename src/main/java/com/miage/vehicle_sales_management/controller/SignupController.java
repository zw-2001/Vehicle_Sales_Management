package com.miage.vehicle_sales_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

    @RequestMapping(value = "/signup")
    public ModelAndView signup(ModelAndView mv) {
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
}
