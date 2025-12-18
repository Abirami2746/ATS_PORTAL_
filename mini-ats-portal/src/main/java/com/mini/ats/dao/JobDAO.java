package com.mini.ats.dao;

import com.mini.ats.util.DBConnect;
import com.mini.ats.model.Job;

import java.sql.*;
import java.util.*;

public class JobDAO {

    public boolean addJob(Job job) {
        boolean status = false;

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO jobs(title, company, location, skills, description) VALUES(?,?,?,?,?)"
            );

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getCompany());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getSkills());
            ps.setString(5, job.getDescription());

            if (ps.executeUpdate() > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Job> getAllJobs() {
        List<Job> list = new ArrayList<>();

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM jobs");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Job j = new Job(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("company"),
                    rs.getString("location"),
                    rs.getString("skills"),
                    rs.getString("description")
                );
                list.add(j);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
