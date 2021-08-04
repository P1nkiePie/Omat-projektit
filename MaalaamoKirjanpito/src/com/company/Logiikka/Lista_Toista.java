package com.company.Logiikka;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Lista_Toista {
    private ArrayList<Auto> lista;

    public Lista_Toista() {
        this.lista=new ArrayList<>();
    }

    //lisätään tiedostosta listaan
    public void paivita_lista() throws IOException {
        try (Scanner lukija = new Scanner(Paths.get("Save.txt"))) {
            while (lukija.hasNextLine()) {
                Auto auto = new Auto();
                String rivi;
                rivi = lukija.nextLine();
                String[] palat = rivi.split(" ");
                String asiakas = palat[3] + " " + palat[4];
                auto.setRek(palat[0]);
                auto.setMerkki(palat[1]);
                auto.setMalli(palat[2]);
                auto.setAsiakas(asiakas);
                auto.setPuh_num(palat[5]);
                auto.setVakuutus(palat[6]);
                auto.setPaivamaara(LocalDate.parse(palat[7]));
                auto.setHinta(palat[8]);
                StringBuilder korjattavat_osat = new StringBuilder();
                for (int i=9; i<palat.length; i++) {
                    korjattavat_osat.append(palat[i]).append(" ");
                }
                auto.setKorjattava_osat(korjattavat_osat.toString());
                    this.lista.add(auto);
            }
        }
    }

    public ArrayList<Auto> getLista() {
        return this.lista;
    }
}
