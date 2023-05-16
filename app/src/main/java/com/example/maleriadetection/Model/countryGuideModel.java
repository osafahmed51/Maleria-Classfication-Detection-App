package com.example.maleriadetection.Model;

public class countryGuideModel {

    String Deaths, Year, ID, Name, Reigon, img;

    public countryGuideModel() {
    }

    public countryGuideModel(String deaths, String year, String ID, String name, String reigon, String img) {
        Deaths = deaths;
        Year = year;
        this.ID = ID;
        Name = name;
        Reigon = reigon;
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
