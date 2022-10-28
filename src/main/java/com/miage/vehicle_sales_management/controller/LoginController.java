package com.miage.vehicle_sales_management.controller;

import com.miage.vehicle_sales_management.dao.UserDao;
import com.miage.vehicle_sales_management.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("userId") String userId, @RequestParam("password") String password) {

        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);

        String name = userDao.loginUser(user);

        if (name != null) {

            mv.addObject("msg", "Welcome " + name + ", You have successfully logged in.");
            mv.setViewName("welcome");

        } else {

            mv.addObject("msg", "Invalid user id or password.");
            mv.setViewName("login");
        }

        return mv;

    }
}

