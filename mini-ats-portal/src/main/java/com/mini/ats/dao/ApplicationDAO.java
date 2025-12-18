package com.mini.ats.dao;
import com.mini.ats.util.DBConnect;
import java.sql.*;

public class ApplicationDAO {

    public boolean applyForJob(int userId, int jobId) {
        boolean status = false;

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO applications(user_id, job_id, status) VALUES (?, ?, 'Applied')"
            );

            ps.setInt(1, userId);
            ps.setInt(2, jobId);

            if (ps.executeUpdate() > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
