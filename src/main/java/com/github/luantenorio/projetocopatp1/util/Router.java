package com.github.luantenorio.projetocopatp1.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Router {

    private static String PATH = "/com/github/luantenorio/projetocopatp1/";

    private static void loadScene(StackPane outlet, String arquivoFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(Router.class.getResource(PATH + arquivoFxml));
            Parent newScene = loader.load();

            outlet.getChildren().clear();
            outlet.getChildren().add(newScene);
        } catch (IOException e) {
            System.err.println("Rota não encontrada" + arquivoFxml);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Arquivo não encontrado" + PATH + arquivoFxml);
            e.printStackTrace();
        }
    }

//    public static void goToStadium(StackPane outlet) {
//        loadScene(outlet, "stadium.fxml");
//    }

}
