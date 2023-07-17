package com.nbeverton.contador_javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {
    private int contador = 0;

    @Override
    public void start(Stage stage) throws Exception {

        Label labelTitulo = new Label("Contador");
        Label labelNumero = new Label("0");

        Button botaoDecremento = new Button("-");
        botaoDecremento.setOnAction(e -> {
            contador--;
            labelNumero.setText(Integer.toString(contador));
        });

        Button botaoIncremento = new Button("+");
        botaoIncremento.setOnAction(e -> {
            contador++;
            labelNumero.setText(Integer.toString(contador));
        });

        HBox boxbotoes = new HBox();
        boxbotoes.setAlignment(Pos.CENTER);
        boxbotoes.setSpacing(10);
        boxbotoes.getChildren().add(botaoDecremento);
        boxbotoes.getChildren().add(botaoIncremento);

        VBox boxPrincipal = new VBox();
        boxPrincipal.setAlignment(Pos.CENTER);
        boxPrincipal.setSpacing(10);
        boxPrincipal.getChildren().add(labelTitulo);
        boxPrincipal.getChildren().add(labelNumero);
        boxPrincipal.getChildren().add(boxbotoes);

        String caminhoCSS = getClass()
                .getResource("/Contador.css")
                .toExternalForm();

        Scene cenaPrincipal = new Scene(boxPrincipal, 400, 400);
        cenaPrincipal.getStylesheets().add(caminhoCSS);

        stage.setScene(cenaPrincipal);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
