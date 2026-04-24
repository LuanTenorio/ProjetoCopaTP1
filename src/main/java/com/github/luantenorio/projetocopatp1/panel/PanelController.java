package com.github.luantenorio.projetocopatp1.panel;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class PanelController {

    @FXML
    private VBox panel;

    @FXML
    public void initialize() {
        this.forceRoundedEdges();
    }

    private void forceRoundedEdges(){
        Rectangle clip = new Rectangle();

        clip.setX(-20);
        clip.setY(0);
        clip.widthProperty().bind(panel.widthProperty().add(20));
        clip.heightProperty().bind(panel.heightProperty());
        clip.setArcWidth(40);
        clip.setArcHeight(40);

        panel.setClip(clip);
    }

}
