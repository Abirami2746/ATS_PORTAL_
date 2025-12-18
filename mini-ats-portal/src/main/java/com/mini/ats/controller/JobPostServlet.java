package com.mini.ats.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import com.mini.ats.util.DBConnect;

@WebServlet("/postJob")
public class JobPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        String title = req.getParameter("title");
        String company = req.getParameter("company");
        String location = req.getParameter("location");
        String skills = req.getParameter("skills");
        String description = req.getParameter("description");

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO jobs(title, company, location, skills, description) VALUES(?,?,?,?,?)"
            );

            ps.setString(1, title);
            ps.setString(2, company);
            ps.setString(3, location);
            ps.setString(4, skills);
            ps.setString(5, description);

            ps.executeUpdate();
            res.sendRedirect("post_success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("error.jsp");
        }
    }
}
