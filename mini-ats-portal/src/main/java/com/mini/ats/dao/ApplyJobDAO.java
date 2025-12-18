package com.mini.ats.dao;

import com.mini.ats.util.DBConnect;
import java.sql.*;

public class ApplyJobDAO {

    public boolean applyJob(int userId, int jobId) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO applications(user_id, job_id, status) VALUES (?, ?, 'Applied')"
            );

            ps.setInt(1, userId);
            ps.setInt(2, jobId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
