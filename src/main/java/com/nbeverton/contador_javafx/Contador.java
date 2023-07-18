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

    private Stage janela;
    private Scene passo1;
    private Scene passo2;

    private void atualizaLabelNumero(Label label) {
        label.setText(Integer.toString(contador));

        label.getStyleClass().remove("verde");
        label.getStyleClass().remove("vermelho");

        if (contador > 0) {
            label.getStyleClass().add("verde");
        } else if (contador < 0) {
            label.getStyleClass().add("vermelho");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        janela = stage;

        criarPasso1();
        criarPasso2();

        janela.setScene(passo1);
        janela.setTitle("Contador @nbeverton");
        janela.show();

    }

    private void criarPasso1() {
        Label labelBemVindo = new Label("Bem vindo");
        labelBemVindo.getStyleClass().add("labelBemVindo");

        Button proximoPasso = new Button("Clique para começar!");
        proximoPasso.setOnAction(e -> {
            janela.setScene(passo2);
            janela.setTitle("Contador @nbeverton");
        });

        VBox boxBemVindo = new VBox();
        boxBemVindo.setAlignment(Pos.CENTER);
        boxBemVindo.getStyleClass().add("bemvindo");
        boxBemVindo.setSpacing(20);
        boxBemVindo.getChildren().add(labelBemVindo);
        boxBemVindo.getChildren().add(proximoPasso);

        String caminhoCSS = getClass()
                .getResource("/Contador.css")
                .toExternalForm();

        passo1 = new Scene(boxBemVindo, 400, 400);
        passo1.getStylesheets().add(caminhoCSS);
    }

    private void criarPasso2(){

        Label labelTitulo = new Label("Contador");
        labelTitulo.getStyleClass().add("titulo");
        Label labelNumero = new Label("0");
        labelNumero.getStyleClass().add("numero");

        Button botaoDecremento = new Button("-");
        botaoDecremento.getStyleClass().add("botoes");
        botaoDecremento.setOnAction(e -> {
            contador--;
            atualizaLabelNumero(labelNumero);
        });

        Button botaoIncremento = new Button("+");
        botaoIncremento.getStyleClass().add("botoes");
        botaoIncremento.setOnAction(e -> {
            contador++;
            atualizaLabelNumero(labelNumero);
        });


        HBox boxbotoes = new HBox();
        boxbotoes.setAlignment(Pos.CENTER);
        boxbotoes.setSpacing(10);
        boxbotoes.getChildren().add(botaoDecremento);
        boxbotoes.getChildren().add(botaoIncremento);

        VBox boxPrincipal = new VBox();
        boxPrincipal.getStyleClass().add("conteudo");
        boxPrincipal.setAlignment(Pos.CENTER);
        boxPrincipal.setSpacing(10);
        boxPrincipal.getChildren().add(labelTitulo);
        boxPrincipal.getChildren().add(labelNumero);
        boxPrincipal.getChildren().add(boxbotoes);


        String caminhoCSS = getClass()
                .getResource("/Contador.css")
                .toExternalForm();

        passo2 = new Scene(boxPrincipal, 400, 400);
        passo2.getStylesheets().add(caminhoCSS);
        passo2.getStylesheets().add("https://fonts.googleapis.com/css2?family=Quicksand");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
