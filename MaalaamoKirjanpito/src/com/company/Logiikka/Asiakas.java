package com.company.Logiikka;

import java.time.LocalDate;

public class Asiakas extends Tyo{
    private String asiakas;
    private String puhnum;

    public Asiakas(String asiakas, String puhnum, String vakuutus, LocalDate paivamaara, String hinta, String korjattavat_osat) {
        super(vakuutus, paivamaara, hinta, korjattavat_osat);
        this.asiakas=asiakas;
        this.puhnum=puhnum;
    }

    public Asiakas() {
    }

    public void setPuh_num(String puhnum) {
        this.puhnum = puhnum;
    }

    public String getAsiakas() {
        return asiakas;
    }

    public String getPuh_num() {
        return puhnum;
    }

    public void setAsiakas(String asiakas) {
        this.asiakas = asiakas;
    }

    @Override
    public String toString() {
        return this.asiakas + " " + this.puhnum + " " + super.toString();
    }

}
