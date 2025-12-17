package com.mini.ats.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import com.mini.ats.util.DBConnect;

@WebServlet("/uploadResume")
@MultipartConfig
public class ResumeUploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        Part filePart = req.getPart("resume");
        String fileName = filePart.getSubmittedFileName();

        String uploadPath = "C:/ATS/uploads/" + fileName;
        filePart.write(uploadPath);

        int userId = (int) req.getSession().getAttribute("userId");

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET resume_path=? WHERE id=?"
            );

            ps.setString(1, uploadPath);
            ps.setInt(2, userId);

            ps.executeUpdate();
            res.sendRedirect("upload_success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
