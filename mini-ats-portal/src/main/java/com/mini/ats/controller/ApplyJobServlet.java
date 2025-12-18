package com.mini.ats.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import com.mini.ats.util.DBConnect;
@WebServlet("/applyJob")
public class ApplyJobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
        throws ServletException, IOException {

        int jobId = Integer.parseInt(req.getParameter("jobId"));
        int userId = (int) req.getSession().getAttribute("userId");

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO applications(user_id, job_id, status) VALUES (?, ?, 'Applied')"
            );
            ps.setInt(1, userId);
            ps.setInt(2, jobId);

            int i = ps.executeUpdate();
            if (i > 0) {
                res.sendRedirect("apply_success.jsp");
            } else {
                res.sendRedirect("error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
