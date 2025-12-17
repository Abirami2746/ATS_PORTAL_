package com.mini.ats.model;

public class Job {

    private int id;
    private String title;
    private String company;
    private String location;
    private String skills;
    private String description;

    // Constructor for inserting (without id)
    public Job(String title, String company, String location, String skills, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.skills = skills;
        this.description = description;
    }

    // Constructor with id (for fetching)
    public Job(int id, String title, String company, String location, String skills, String description) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.skills = skills;
        this.description = description;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getSkills() {
        return skills;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

