package com.github.luantenorio.projetocopatp1.util;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Window {

    public static void setWindowTitle(Node node, String titulo) {
        Platform.runLater(() -> {
            if (node != null && node.getScene() != null && node.getScene().getWindow() != null) {
                Stage janela = (Stage) node.getScene().getWindow();
                janela.setTitle("Sistema Copa - " + titulo);
            }
        });
    }
}
