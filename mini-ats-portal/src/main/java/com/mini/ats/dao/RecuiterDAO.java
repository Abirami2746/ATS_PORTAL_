package com.mini.ats.dao;
import com.mini.ats.util.DBConnect;
import com.mini.ats.model.Application;
import java.sql.*;
import java.util.*;

public class RecuiterDAO {
    // Get all applicants for a job
    public List<Application> getApplicants(int jobId) {
        List<Application> list = new ArrayList<>();

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT a.id, u.name, u.email, u.resume_path, a.status " +
                "FROM applications a JOIN users u ON a.user_id=u.id WHERE a.job_id=?"
            );

            ps.setInt(1, jobId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Application app = new Application(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("resume_path"),
                    rs.getString("status")
                );
                list.add(app);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    // Rate candidate
    public boolean rateCandidate(int applicationId, int rating) {
        boolean status = false;

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE applications SET rating=? WHERE id=?"
            );

            ps.setInt(1, rating);
            ps.setInt(2, applicationId);

            if (ps.executeUpdate() > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    // Send recruiter message (interview/reject/offer)
    public boolean sendMessage(int applicationId, String type) {
        boolean status = false;

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE applications SET status=? WHERE id=?"
            );

            ps.setString(1, type);
            ps.setInt(2, applicationId);

            if (ps.executeUpdate() > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
