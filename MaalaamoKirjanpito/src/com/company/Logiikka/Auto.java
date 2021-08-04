package com.company.Logiikka;

import java.time.LocalDate;

public class Auto extends Asiakas{
    private String rek;
    private String merkki;
    private String malli;

    public Auto() {

    }

    public Auto(String rek, String merkki, String malli, String asiakas, String puhnum, String vakuutus, LocalDate paivamaara, String hinta, String korjattavat_osat) {
        super(asiakas, puhnum, vakuutus, paivamaara, hinta, korjattavat_osat);
        this.rek=rek;
        this.merkki=merkki;
        this.malli=malli;
    }

    public void setRek(String rek) {
        this.rek = rek;
    }

    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }

    public void setMalli(String malli) {
        this.malli = malli;
    }

    public String getRek() {
        return rek;
    }

    public String getMerkki() {
        return merkki;
    }

    public String getMalli() {
        return malli;
    }

    @Override
    public String toString() {
        return this.rek + " " + this.merkki + " " + this.malli + " " + super.toString() + "\n";
    }
}
