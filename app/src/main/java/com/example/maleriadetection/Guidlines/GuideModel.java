package com.example.maleriadetection.Guidlines;

public class GuideModel {

    String ID,Name;

    public GuideModel() {
    }

    public GuideModel(String ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
