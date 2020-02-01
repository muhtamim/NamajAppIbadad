package org.atctech.al_quranbangla.Model;

public class Ayat {

    private String id;
    private String sura_id;
    private String verse_id;
    private String arabic_indopak;
    private String trans;
    private String bn_muhi;
    private String pages;
    private String para;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSura_id() {
        return sura_id;
    }

    public void setSura_id(String sura_id) {
        this.sura_id = sura_id;
    }

    public String getVerse_id() {
        return verse_id;
    }

    public void setVerse_id(String verse_id) {
        this.verse_id = verse_id;
    }

    public String getArabic_indopak() {
        return arabic_indopak;
    }

    public void setArabic_indopak(String arabic_indopak) {
        this.arabic_indopak = arabic_indopak;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getBn_muhi() {
        return bn_muhi;
    }

    public void setBn_muhi(String bn_muhi) {
        this.bn_muhi = bn_muhi;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
