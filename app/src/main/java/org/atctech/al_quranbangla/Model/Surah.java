package org.atctech.al_quranbangla.Model;

public class Surah {

    private int id;
    private String ayat;
    private String name;
    private String meaning;
    private String name_ar;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getName_ar() {
        return name_ar;
    }

    public void setName_ar(String name_ar) {
        this.name_ar = name_ar;
    }
}
