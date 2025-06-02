package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CarsServlet", urlPatterns = "/cars")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "Hello from Jakarta Servlet - cars!";
        String[] users = {"BMW", "Mercedes", "Audi"};
        req.setAttribute("message", message);
        req.setAttribute("cars", users);

        req.getRequestDispatcher("/WEB-INF/cars.jsp").forward(req, resp);
    }
}
