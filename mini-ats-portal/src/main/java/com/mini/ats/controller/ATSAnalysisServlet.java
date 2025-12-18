package com.mini.ats.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/atsAnalysis")
public class ATSAnalysisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String resumeText = req.getParameter("resumeText");
        String jobDescription = req.getParameter("jobDescription");

        String[] jdWords = jobDescription.split(" ");
        int totalKeywords = jdWords.length;
        int matched = 0;

        for (String kw : jdWords) {
            if (resumeText.toLowerCase().contains(kw.toLowerCase())) {
                matched++;
            }
        }

        int score = (matched * 100) / totalKeywords;

        req.setAttribute("score", score);
        req.getRequestDispatcher("ats_result.jsp").forward(req, res);
    }
}
