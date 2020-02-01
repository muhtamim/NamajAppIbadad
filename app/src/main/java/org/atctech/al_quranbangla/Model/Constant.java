package org.atctech.al_quranbangla.Model;

public class Constant {
    String seheri;
    String iftar;
    String date;

    public Constant(String seheri, String iftar, String date) {
        this.seheri = seheri;
        this.iftar = iftar;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeheri() {
        return seheri;
    }

    public void setSeheri(String seheri) {
        this.seheri = seheri;
    }

    public String getIftar() {
        return iftar;
    }

    public void setIftar(String iftar) {
        this.iftar = iftar;
    }


}
