package com.example.maleriadetection.Model;

public class DetailsModel {


    String ID, Name,Reigon, img;

    public DetailsModel() {
    }

    public DetailsModel(String ID, String name, String reigon, String img) {
        this.ID = ID;
        Name = name;
        Reigon = reigon;
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

    public String getReigon() {
        return Reigon;
    }

    public void setReigon(String reigon) {
        Reigon = reigon;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
