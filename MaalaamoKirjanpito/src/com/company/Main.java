package com.company;

import com.company.Logiikka.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //luodaan root BorderPane
        BorderPane root = new BorderPane();
        Insets insets = new Insets(0, 200, 0, 0);
        //luodaan BorderPane sulje painikkeelle
        BorderPane ala_painikkeet = new BorderPane();
        //luodaan Scene johon asetetaan root BorderPane
        Scene scene = new Scene(root);
        //Teksi alue työn tietoja varten
        TextArea textArea= new TextArea();
        //poistetaan textareasta muokkaus mahdollisuus
        textArea.setEditable(false);
        //asetetaan teksi alue root panen oikeaan reunaan
        root.setRight(textArea);
        //Hbox etsi hakukentälle
        HBox hakukentta = new HBox();
        //hbox asetetaan root panen yläreunaan
        root.setTop(hakukentta);

        Lista_Toista lista_toista = new Lista_Toista();
        lista_toista.paivita_lista();

        //luodaan sulje painike
        Button sulje = new Button("Sulje");
        //sulje painike sulkee ohjelman
        sulje.setOnAction(e -> stage.close());
        //asetetaan sulje painike sulje_painike Panen oikeaan reunaan
        ala_painikkeet.setRight(sulje);
        //asetetaan sulje_painike Pane root Panen alareunaan
        root.setBottom(ala_painikkeet);

        //luodaan uusi_työ painike
        Button uusi_tyo = new Button("Uusi työ");
        //uusi_työ painike avaa UUsiTyoIkkunan
        uusi_tyo.setOnAction(e -> UusiTyoIkkuna.uusityoikkuna(lista_toista));

        //luodaan VBox ja asetetaan siihen uusi_tyo painike
        VBox vasen_reuna = new VBox(uusi_tyo);
        vasen_reuna.setPadding(new Insets(50, 500, 50, 5));

        //asetetaan VBox vasen_reuna root BorderPanen vasempaan reunaan
        root.setLeft(vasen_reuna);

        //tehdään VBox
        VBox vbox = new VBox();
        vbox.setPrefWidth(500);
        vbox.setSpacing(5);

        //tulostetaan rek, merkki, malli painikkeisiin
        ArrayList painikkeet = new ArrayList<>();
        int i=0;
        while (i<lista_toista.getLista().size()) {
            Button button = new Button();
            button.setMaxSize(400, 20);
            button.setText(lista_toista.getLista().get(i).getRek() + " " + lista_toista.getLista().get(i).getMerkki() +
                    " " + lista_toista.getLista().get(i).getMalli());
            int finalI = i;
            button.setOnAction(e -> textArea.setText(TyonTiedot.tyonTiedot(lista_toista.getLista().get(finalI))));
            painikkeet.add(button);
            vbox.getChildren().add(button);
            i++;
        }

        //Tehdään ScrollPane
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setPadding(new Insets(5,20,20,140));

        //asetetaan vbox root panen keskelle
        root.setCenter(scrollPane);
        BorderPane.setMargin(scrollPane, insets);

        //luodaan etsi hakukenttä
        TextField etsi = new TextField();
        etsi.setPromptText("Etsi rek");

        //etsi hakukentän toiminto
        etsi.setOnAction(e -> textArea.setText(lista_toista.hae_listasta(etsi.getText())));

        //asetetaan etsi hakukenttä hboxiin
        hakukentta.getChildren().add(etsi);
        
        //Päivitä painike
        Button paivita = new Button("Päivitä");
        //Päivitä painike päivittää työt listan
        paivita.setOnAction(e -> {
            Button button = new Button();
            button.setMaxSize(400, 20);
            for (int p=0; p<lista_toista.getLista().size(); p++) {
                if (p==lista_toista.getLista().size()-1) {
                    button.setText(lista_toista.getLista().get(p).getRek() + " " + lista_toista.getLista().get(p).getMerkki() +
                            " " + lista_toista.getLista().get(p).getMalli());
                }
                int finalP = p;
                button.setOnAction(k -> textArea.setText(TyonTiedot.tyonTiedot(lista_toista.getLista().get(finalP))));
            }
                vbox.getChildren().add(button);
        });
        ala_painikkeet.setRight(paivita);

        //asetetaan stagelle scene
        stage.setScene(scene);
        //pää ikkunan otsikko
        stage.setTitle("Maalaamo kirjanpito");
        //avataan pää ikkuna koko näytön kokoisena
        stage.setMaximized(true);
        stage.show();
    }
}
