package com.mini.ats.model;

public class Application {
    private int id;
    private String name;
    private String email;
    private String resumePath;
    private String status;

    public Application(int id, String name, String email, String resumePath, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.resumePath = resumePath;
        this.status = status;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getResumePath() { return resumePath; }
    public String getStatus() { return status; }

    // Setters (optional)
}
