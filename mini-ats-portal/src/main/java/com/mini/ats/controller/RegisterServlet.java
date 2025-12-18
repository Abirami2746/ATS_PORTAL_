package com.mini.ats.controller;

import com.mini.ats.dao.UserDAO;
import com.mini.ats.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String role = req.getParameter("role");

        // 1. Check if email already exists
        if (userDAO.emailExists(email)) {
            resp.sendRedirect("seeker-register.html?error=email_exists");
            return;
        }

        // 2. Create user object
        User u = new User(name, email, password, phone, role);

        // 3. Save user
        boolean saved = userDAO.registerUser(u);

        if (saved) {
            resp.sendRedirect("seeker-login.html?success=registered");
        } else {
            resp.sendRedirect("seeker-register.html?error=failed");
        }
    }
}
