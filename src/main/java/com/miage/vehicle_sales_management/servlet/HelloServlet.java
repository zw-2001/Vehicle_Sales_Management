package com.miage.vehicle_sales_management.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

/**
 * This class is a servlet that displays a simple message.
 * @author 2019-2020 MIAGE students
 * @version 1.0
 * @since 1.0
 * @see jakarta.servlet.http.HttpServlet
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void init() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // go to reservation.jsp page
        try {
            request.getRequestDispatcher("/reservation.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}