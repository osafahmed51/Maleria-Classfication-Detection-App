package com.example.maleriadetection.Model;

public class yearsModel {

    String Falciparum,Imported, Indigenous, Mixed, Name,Other,Value,Vivax,Introduced,img,Death,Reigon;

    public yearsModel() {
    }

    public yearsModel(String falciparum, String imported, String indigenous, String mixed, String name, String other, String value, String vivax, String introduced, String img, String death, String reigon) {
        Falciparum = falciparum;
        Imported = imported;
        Indigenous = indigenous;
        Mixed = mixed;
        Name = name;
        Other = other;
        Value = value;
        Vivax = vivax;
        Introduced = introduced;
        this.img = img;
        Death = death;
        Reigon = reigon;
    }

    public String getFalciparum() {
        return Falciparum;
    }

    public void setFalciparum(String falciparum) {
        Falciparum = falciparum;
    }

    public String getImported() {
        return Imported;
    }

    public void setImported(String imported) {
        Imported = imported;
    }

    public String getIndigenous() {
        return Indigenous;
    }

    public void setIndigenous(String indigenous) {
        Indigenous = indigenous;
    }

    public String getMixed() {
        return Mixed;
    }

    public void setMixed(String mixed) {
        Mixed = mixed;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getVivax() {
        return Vivax;
    }

    public void setVivax(String vivax) {
        Vivax = vivax;
    }

    public String getIntroduced() {
        return Introduced;
    }

    public void setIntroduced(String introduced) {
        Introduced = introduced;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDeath() {
        return Death;
    }

    public void setDeath(String death) {
        Death = death;
    }

    public String getReigon() {
        return Reigon;
    }

    public void setReigon(String reigon) {
        Reigon = reigon;
    }
}