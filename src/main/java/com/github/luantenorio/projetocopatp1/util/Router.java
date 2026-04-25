package com.github.luantenorio.projetocopatp1.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Router {

    private static String PATH = "/com/github/luantenorio/projetocopatp1/view/";

    public static void NavigateTo(StackPane outlet, ViewName name) {
        String filename = name.getFileFxmlName();

        try {
            FXMLLoader loader = new FXMLLoader(Router.class.getResource(PATH + filename));
            Parent newScene = loader.load();

            outlet.getChildren().clear();
            outlet.getChildren().add(newScene);
        } catch (IOException e) {
            System.err.println("Rota não encontrada" + filename);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Arquivo não encontrado" + PATH + filename);
            e.printStackTrace();
        }
    }

}
