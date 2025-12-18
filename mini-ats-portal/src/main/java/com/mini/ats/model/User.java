package com.mini.ats.model;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String role;
    private String resumePath;

    // ✅ REQUIRED: Default constructor
    public User() {
    }

    // ✅ Constructor for registration
    public User(String name, String email, String password, String phone, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    // ✅ Full constructor (login / fetch)
    public User(int id, String name, String email, String password,
                String phone, String role, String resumePath) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.resumePath = resumePath;
    }

    // ---------- Getters ----------
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhone() { return phone; }
    public String getRole() { return role; }
    public String getResumePath() { return resumePath; }

    // ---------- Setters ----------
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setRole(String role) { this.role = role; }
    public void setResumePath(String resumePath) { this.resumePath = resumePath; }
}
