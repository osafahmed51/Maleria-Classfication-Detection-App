package com.example.maleriadetection.Model;

public class caseModel {
    String ID,Name,img;
    public caseModel() {
    }

    public caseModel(String ID, String name, String img) {
        this.ID = ID;
        Name = name;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}