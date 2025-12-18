package com.mini.ats.controller;

import com.mini.ats.dao.UserDAO;
import com.mini.ats.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDAO.loginUser(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", user);

            if ("seeker".equals(user.getRole())) {
                response.sendRedirect("jsp/SeekerDashboard.jsp");
            } else {
                response.sendRedirect("jsp/recruiterDashboard.jsp");
            }
        } else {
            response.sendRedirect("jsp/login.jsp?error=invalid");
        }
    }
}
