package com.mini.ats.dao;
import com.mini.ats.util.DBConnect;
import com.mini.ats.model.User;
import java.sql.*;
public class UserDAO {
   // Register new user
    public boolean registerUser(User user) {
        boolean status = false;
        try {
            Connection con = DBConnect.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name, email, password, phone, role) VALUES(?,?,?,?,?)"
            );

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getRole());

            if (ps.executeUpdate() > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }  // Login
    public User loginUser(String email, String password) {
        User user = null;

        try {
            Connection con = DBConnect.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("role"),
                    rs.getString("resume_path")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }   // Check duplicate email
    public boolean emailExists(String email) {
        boolean exists = false;

        try {
            Connection con = DBConnect.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT id FROM users WHERE email=?"
            );
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            exists = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exists;
    }   // Get user by id
    public User getUserById(int id) {
        User user = null;

        try {
            Connection con = DBConnect.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE id=?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("role"),
                    rs.getString("resume_path")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }    // Upload resume
    public boolean updateResume(int userId, String path) {
        boolean status = false;

        try {
            Connection con = DBConnect.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET resume_path=? WHERE id=?"
            );

            ps.setString(1, path);
            ps.setInt(2, userId);

            if (ps.executeUpdate() > 0) status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
