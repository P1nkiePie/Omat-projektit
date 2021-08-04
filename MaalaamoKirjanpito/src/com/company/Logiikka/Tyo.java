package com.company.Logiikka;

import java.time.LocalDate;

public class Tyo {
    private String vakuutus;
    private LocalDate paivamaara;
    private String hinta;
    private String korjattava_osat;

    public Tyo(String vakuutus, LocalDate paivamaara, String hinta, String korjattava_osat) {
        this.vakuutus=vakuutus;
        this.paivamaara=paivamaara;
        this.hinta=hinta;
        this.korjattava_osat=korjattava_osat;
    }

    public Tyo() {
    }

    public void setVakuutus(String vakuutus) {
        this.vakuutus = vakuutus;
    }

    public void setPaivamaara(LocalDate paivamaara) {
        this.paivamaara = paivamaara;
    }

    public void setHinta(String hinta) {
        this.hinta = hinta;
    }

    public String getVakuutus() {
        return vakuutus;
    }

    public LocalDate getPaivamaara() {
        return paivamaara;
    }

    public String getHinta() {
        return hinta;
    }

    public void setKorjattava_osat(String korjattava_osat) {
        this.korjattava_osat = korjattava_osat;
    }

    public String getKorjattava_osat() {
        return korjattava_osat;
    }

    @Override
    public String toString() {
        return this.vakuutus + " " + this.paivamaara + " " + this.hinta + "€" + " " + this.korjattava_osat;
    }
}
