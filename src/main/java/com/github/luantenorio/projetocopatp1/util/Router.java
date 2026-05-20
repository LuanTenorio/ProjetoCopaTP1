package com.github.luantenorio.projetocopatp1.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Router {

    private static String PATH = "/com/github/luantenorio/projetocopatp1/view/";

    private static StackPane outlet;

    public static void setOutlet(StackPane pane) {
        Router.outlet = pane;
    }

    public static void navigateTo(ViewName name){
        navigateTo(name, null);
    }

    public static void navigateTo(ViewName name, Object dados) {
        String filename = null;
        try {
            String[] texts = name.getFileFxmlName().split("\\|");
            filename = texts[0];
            String title = texts[1];

            FXMLLoader loader = new FXMLLoader(Router.class.getResource(PATH + filename));
            Parent newScene = loader.load();

            if (dados != null) {
                Object controller = loader.getController();
                if (controller instanceof DataController) {
                    ((DataController) controller).getData(dados);
                }
            }

            outlet.getChildren().clear();
            outlet.getChildren().add(newScene);

            Window.setWindowTitle(outlet, title);
        } catch (IOException e) {
            System.err.println("Rota não encontrada " + filename);
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Arquivo não encontrado " + PATH + filename);
            e.printStackTrace();
        }
    }

}
