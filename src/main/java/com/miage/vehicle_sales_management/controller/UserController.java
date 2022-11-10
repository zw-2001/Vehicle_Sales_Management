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
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        ModelAndView mv = new ModelAndView();

        User user = User.getInstance();
        user.setUsername(username);
        user.setPassword(password);

        int login = userDao.loginUser(user);

        if (login != 0) {
            mv.addObject("msg", "Welcome " + user.getUsername() + ", You have successfully logged in.");
            mv.setViewName("welcome");
        } else {
            mv.addObject("msg", "Invalid username or password.");
            mv.setViewName("login");
        }
        return mv;
    }
}
