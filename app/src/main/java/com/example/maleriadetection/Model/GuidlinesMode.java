package com.example.maleriadetection.Model;

public class GuidlinesMode {

    String Year,Deaths;

    public GuidlinesMode() {
    }

    public GuidlinesMode(String year, String deaths) {
        Year = year;
        Deaths = deaths;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getDeaths() {
        return Deaths;
    }

    public void setDeaths(String deaths) {
        Deaths = deaths;
    }
}
