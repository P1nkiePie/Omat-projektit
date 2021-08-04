package com.company.Logiikka;

public class TyonTiedot {

    public static String tyonTiedot(Auto auto) {
        return "rek: " + auto.getRek() + "\nMerkki: " + auto.getMerkki() +
                "\nmalli: " + auto.getMalli() + "\nAsiakas: " + auto.getAsiakas() +
                "\nPuhnum: " + auto.getPuh_num() + "\nVakuutus työ: " + auto.getVakuutus() +
                "\nPäivämäärä: " + auto.getPaivamaara() + "\nHinta: " + auto.getHinta() +
                "\nKorjaukset:\n" + auto.getKorjattava_osat();
    }
}
