package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.UserDao;
import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("email") String email, @RequestParam("password") String password, ModelAndView mv) {

        int login = new UserDao().loginUser(email, password);

        if (login != 0) {
            User user = User.getInstance();
            mv.addObject("msg", "Welcome " + user.getEmail() + ", You have successfully logged in.");
            mv.setViewName("welcome");
        } else {
            mv.addObject("msg", "Invalid email or password.");
            mv.setViewName("index");
        }
        return mv;
    }
}
