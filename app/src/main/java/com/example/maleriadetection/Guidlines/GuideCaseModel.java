package com.example.maleriadetection.Guidlines;

public class GuideCaseModel {

    String ID, Name, Reigon, img, Deaths, Year, name;

    public GuideCaseModel() {
    }

    public GuideCaseModel(String ID, String name, String reigon, String img, String deaths, String year, String name1) {
        this.ID = ID;
        Name = name;
        Reigon = reigon;
        this.img = img;
        Deaths = deaths;
        Year = year;
        this.name = name1;
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

    public String getDeaths() {
        return Deaths;
    }

    public void setDeaths(String deaths) {
        Deaths = deaths;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}