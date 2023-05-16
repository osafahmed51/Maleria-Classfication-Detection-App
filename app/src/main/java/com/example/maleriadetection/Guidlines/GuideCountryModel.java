package com.example.maleriadetection.Guidlines;

public class GuideCountryModel {

    String ID, Name, Reigon, Deaths, Year, img,name;

    public GuideCountryModel() {
    }

    public GuideCountryModel(String ID, String name, String reigon, String deaths, String year, String img, String name1) {
        this.ID = ID;
        this.Name = name;
        Reigon = reigon;
        Deaths = deaths;
        Year = year;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}