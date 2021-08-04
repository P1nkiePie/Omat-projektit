package com.company.Logiikka;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileUtility {

    public static void Tallenna_Tiedostoon(String rek, String merkki, String malli, String asiakas, String puhnum, String vakuutus, LocalDate paivamaara, String hinta, String osat) {
        Auto auto = new Auto(rek, merkki, malli, asiakas, puhnum, vakuutus, paivamaara, hinta, osat);
        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Save.txt", true));
            writer.append(auto.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
