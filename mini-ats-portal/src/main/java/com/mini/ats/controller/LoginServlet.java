package com.mini.ats.controller;

import com.mini.ats.dao.UserDAO;
import com.mini.ats.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDAO userDAO = new UserDAO();

    // Allow GET requests (so 405 error won't come)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);   // Forward GET → POST
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        User user = userDAO.loginUser(email, pass);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);

            resp.sendRedirect("jsp/seekerDashboard.jsp");

        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3 style='color:red;'>Invalid Email or Password</h3>");
        }
    }
}
