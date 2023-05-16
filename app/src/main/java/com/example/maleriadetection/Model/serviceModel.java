package com.example.maleriadetection.Model;

public class serviceModel {
    String Experience,Location,Phone,Name;

    public serviceModel() {
    }

    public serviceModel(String experience, String location, String phone, String name) {
        Experience = experience;
        Location = location;
        Phone = phone;
        Name = name;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
