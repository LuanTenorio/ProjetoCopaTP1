package com.github.luantenorio.projetocopatp1.panel;

import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class PanelController{

    @FXML
    private VBox panel;

    @FXML
    private StackPane routerOutlet;

    @FXML
    public void initialize() {
        this.forceRoundedEdges();
        Platform.runLater(this::initialRouter);
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
        Router.setOutlet(this.routerOutlet);
    }

    private void initialRouter(){
        this.navigateToEstadium();
    }

    public void navigateToEstadium(){
        Router.navigateTo(ViewName.STADIUM);
    }

    public void navigateToPlayer() {Router.navigateTo(ViewName.PLAYER);}

    public void navigateToTeam() {Router.navigateTo(ViewName.TEAM);}
  
    public void navigateToMatch() {Router.navigateTo(ViewName.MATCH);}

    public void navigateToReferee() {Router.navigateTo(ViewName.REFEREE);}

}
