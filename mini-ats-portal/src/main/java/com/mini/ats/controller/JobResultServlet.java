package com.mini.ats.controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import com.mini.ats.util.DBConnect;
@WebServlet("/jobResults")
public class JobResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM jobs");

            ResultSet rs = ps.executeQuery();
            req.setAttribute("jobList", rs);
            req.getRequestDispatcher("job_results.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

