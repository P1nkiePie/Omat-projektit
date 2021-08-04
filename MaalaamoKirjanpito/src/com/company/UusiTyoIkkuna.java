package com.company;

import com.company.Logiikka.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class UusiTyoIkkuna {

    public static void uusityoikkuna(Lista_Toista lista_toista) {
        //luodaan uusi stage
        Stage stage = new Stage();
        //luodaan uusi root BorderPane
        BorderPane root = new BorderPane();
        //GridPane tietojen Teksikentille
        GridPane tiedot = new GridPane();
        tiedot.setHgap(4);
        tiedot.setVgap(2);
        //GridPane tiedot root Borderpanen yläreunaan
        root.setTop(tiedot);
        //luodaan uusi scene ja asetetaan root BorderPane
        Scene scene = new Scene(root);

        //Tekstikenttä rekisteri numerolle
        TextField rek = new TextField();
        rek.setPromptText("Rek");
        //asetetaan rek Teksikenttä GridPaneen
        tiedot.add(rek, 5, 0);

        //Teksikenttä merkille
        TextField merkki = new TextField();
        merkki.setPromptText("Merkki");
        //asetetaan merkki Tekstikenttä Gridpaneen
        tiedot.add(merkki, 5, 5);
        rek.setOnKeyPressed(k -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                merkki.requestFocus();
            }
        });

        //Teksikenttä mallille
        TextField malli = new TextField();
        malli.setPromptText("Malli");
        //asetetaan malli Tekstikenttä Gridpaneen
        tiedot.add(malli, 5, 10);
        merkki.setOnKeyPressed(k -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                malli.requestFocus();
            }
        });

        //Teksikenttä asiakkaalle
        TextField asiakas = new TextField();
        asiakas.setPromptText("Asiakas");
        //asetetaan asiakas Tekstikenttä Gridpaneen
        tiedot.add(asiakas, 30, 0);
        malli.setOnKeyPressed(k -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                asiakas.requestFocus();
            }
        });

        //Teksikenttä puhelinnumerolle
        TextField puhnum = new TextField();
        puhnum.setPromptText("Puh num");
        //asetetaan puhnum Tekstikenttä Gridpaneen
        tiedot.add(puhnum, 30, 5);
        asiakas.setOnKeyPressed(k -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                puhnum.requestFocus();
            }
        });

        //ComboBox vakuutus työlle
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "ei",
                        "OP",
                        "Nordea",
                        "IF"
                );
        ComboBox vakuutus = new ComboBox(options);
        vakuutus.setPromptText("Vakuutus tyo");
        //asetetaan vakuutus tiedot GridPaneen
        tiedot.add(vakuutus, 60, 0);
        puhnum.setOnKeyPressed(k -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                vakuutus.requestFocus();
            }
        });

        //Kalenteri työn vastaanottamis päivää varten
        DatePicker paivamaara = new DatePicker();
        paivamaara.setPromptText("Saapunut");
        //asetetaan kalenteri GridPaneen
        tiedot.add(paivamaara, 60, 5);
        vakuutus.setOnKeyPressed(k -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                paivamaara.requestFocus();
            }
        });

        //Tekstikenttä hinnalle
        TextField hinta = new TextField();
        hinta.setPromptText("Hinta");
        //asetetaan hinta Gridpaneen
        tiedot.add(hinta, 60, 10);
        paivamaara.setOnKeyPressed(k -> {
            if (k.getCode().equals(KeyCode.ENTER)) {
                hinta.requestFocus();
            }
        });

        //GridPane CheckBoxeille

        GridPane korjattavat_osat = new GridPane();
        //asetetaan korjattavat_osat GridPane root BorderPanen keskelle
        root.setCenter(korjattavat_osat);
        korjattavat_osat.setHgap(2);
        korjattavat_osat.setVgap(4);

        ArrayList<String> osat_lista = new ArrayList<>();

        //CheckBoxit korjattaville osille
        CheckBox VasenEtuLokasuoja = new CheckBox("VasenEtuLokasuoja");
        VasenEtuLokasuoja.setOnAction(event -> {
            if (VasenEtuLokasuoja.isSelected()) osat_lista.add(VasenEtuLokasuoja.getText());
        });

        CheckBox VasenEtuOvi = new CheckBox("VasenEtuOvi");
        VasenEtuOvi.setOnAction(event -> {
            if (VasenEtuOvi.isSelected()) osat_lista.add(VasenEtuOvi.getText());
        });

        CheckBox VasenTakaOvi = new CheckBox("VasenTakaOvi");
        VasenTakaOvi.setOnAction(event -> {
            if (VasenTakaOvi.isSelected()) osat_lista.add(VasenTakaOvi.getText());
        });

        CheckBox VasenTakaLokasuoja = new CheckBox("VasenTakaLokasuoja");
        VasenTakaLokasuoja.setOnAction(event -> {
            if (VasenTakaLokasuoja.isSelected()) osat_lista.add(VasenTakaLokasuoja.getText());
        });

        CheckBox VasenHelma = new CheckBox("VasenHelma");
        VasenHelma.setOnAction(event -> {
            if (VasenHelma.isSelected()) osat_lista.add(VasenHelma.getText());
        });

        CheckBox OikeaEtuLokasuoja = new CheckBox("OikeaEtuLokasuoja");
        OikeaEtuLokasuoja.setOnAction(event -> {
            if (OikeaEtuLokasuoja.isSelected()) osat_lista.add(OikeaEtuLokasuoja.getText());
        });

        CheckBox OikeaEtuOvi = new CheckBox("OikeaEtuOvi");
        OikeaEtuOvi.setOnAction(event -> {
            if (OikeaEtuOvi.isSelected()) osat_lista.add(OikeaEtuOvi.getText());
        });

        CheckBox OikeaTakaOvi = new CheckBox("OikeaTakaOvi");
        OikeaTakaOvi.setOnAction(event -> {
            if (OikeaTakaOvi.isSelected()) osat_lista.add(OikeaTakaOvi.getText());
        });

        CheckBox OikeaTakaLokasuoja = new CheckBox("OikeaTakaLokasuoja");
        OikeaTakaLokasuoja.setOnAction(event -> {
            if (OikeaTakaLokasuoja.isSelected()) osat_lista.add(OikeaTakaLokasuoja.getText());
        });

        CheckBox OikeaHelma = new CheckBox("OikeaHelma");
        OikeaHelma.setOnAction(event -> {
            if (OikeaHelma.isSelected()) osat_lista.add(OikeaHelma.getText());
        });

        CheckBox Etupuskuri = new CheckBox("Etupuskuri");
        Etupuskuri.setOnAction(event -> {
            if (Etupuskuri.isSelected()) osat_lista.add(Etupuskuri.getText());
        });

        CheckBox Katto = new CheckBox("Katto");
        Katto.setOnAction(event -> {
            if (Katto.isSelected()) osat_lista.add(Katto.getText());
        });

        CheckBox Takaluukku = new CheckBox("Takaluukku");
        Takaluukku.setOnAction(event -> {
            if (Takaluukku.isSelected()) osat_lista.add(Takaluukku.getText());
        });

        CheckBox TakaPuskuri = new CheckBox("TakaPuskuri");
        TakaPuskuri.setOnAction(event -> {
            if (TakaPuskuri.isSelected()) osat_lista.add(TakaPuskuri.getText());
        });

        //asetetaan CheckBoxit Gridpaneen korjattavat_osat
        korjattavat_osat.add(VasenEtuLokasuoja, 0, 5);
        korjattavat_osat.add(VasenEtuOvi, 0, 12);
        korjattavat_osat.add(VasenTakaOvi, 0, 19);
        korjattavat_osat.add(VasenTakaLokasuoja, 0, 26);
        korjattavat_osat.add(VasenHelma, 0, 33);
        korjattavat_osat.add(OikeaEtuLokasuoja, 20, 5);
        korjattavat_osat.add(OikeaEtuOvi, 20, 12);
        korjattavat_osat.add(OikeaTakaOvi, 20, 19);
        korjattavat_osat.add(OikeaTakaLokasuoja, 20, 26);
        korjattavat_osat.add(OikeaHelma, 20, 33);
        korjattavat_osat.add(Etupuskuri, 40, 5);
        korjattavat_osat.add(Katto, 40, 12);
        korjattavat_osat.add(Takaluukku, 40, 19);
        korjattavat_osat.add(TakaPuskuri, 40, 26);

        //Tallenna ja peruuta painikkeille BorderPane
        BorderPane painike_pane = new BorderPane();

        //tallenna_pane root panen alareunaan
        root.setBottom(painike_pane);

        //Tallenna painike
        Button tallenna = new Button("Tallenna");

        //tallenna painike asetetaan sille tehdylle BorderPanelle
        painike_pane.setRight(tallenna);

        //tallentaa uuden auto olion tekstitiedostoon
        tallenna.setOnAction(e -> {
            String rek1=rek.getText();
            String merkki1=merkki.getText();
            String malli1=malli.getText();
            String asiakas1=asiakas.getText();
            String puhnum1=puhnum.getText();
            String vakuutus1=(String) vakuutus.getValue();
            LocalDate paivamaara1 = paivamaara.getValue();
            String hinta1 = hinta.getText();
            String osat1 = "";
            for (String o: osat_lista) {
                osat1+=o+" ";
            }
            FileUtility.Tallenna_Tiedostoon(rek1, merkki1, malli1, asiakas1, puhnum1, vakuutus1, paivamaara1, hinta1, osat1);
            try {
                lista_toista.paivita_lista();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            stage.close();
        });

        //peruuta painike
        Button peruuta = new Button("Peruuta");

        //asetetaan peruuta painike painike_pane vasempaan reunaan
        painike_pane.setLeft(peruuta);

        //peruuta painike toiminto
        peruuta.setOnAction(e -> {
            rek.clear();
            merkki.clear();
            malli.clear();
            asiakas.clear();
            puhnum.clear();
            vakuutus.valueProperty().set(null);
            paivamaara.valueProperty().set(null);
            hinta.clear();
            stage.close();
        });


        //asetetaan scene stageen
        stage.setScene(scene);

        //asetetaan UusiTyoIkkunalle otsikko
        stage.setTitle("Uusi tyo");
        stage.show();
    }
}
