package com.github.luantenorio.projetocopatp1.panel;

import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.application.Platform;
import javafx.fxml.FXML;
import com.github.luantenorio.projetocopatp1.users.UserSession;
import com.github.luantenorio.projetocopatp1.users.AdminEntity;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;


public class PanelController{

    @FXML
    private VBox panel;

    @FXML
    private Button btnGestao;

    @FXML
    private StackPane routerOutlet;

    @FXML
    public void initialize() {
        this.forceRoundedEdges();
        this.verifyAccess();
        Platform.runLater(this::initialRouter);
    }

    private void verifyAccess() {
        UserSession sessao = UserSession.getInstance();

        if (sessao.isLoggedIn() && sessao.getLoggedUser() instanceof AdminEntity) {
            // se for admin, o botão fica visível e ativo no layout
            btnGestao.setVisible(true);
            btnGestao.setManaged(true);
        } else {
            // se for organizador ou árbitro  o botão some e o layout se ajusta
            btnGestao.setVisible(false);
            btnGestao.setManaged(false);
        }
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
        this.navigateToFeed();
    }

    public void navigateToFeed() { Router.navigateTo(ViewName.FEED); }

    public void navigateToEstadium(){
        Router.navigateTo(ViewName.STADIUM);
    }

    public void navigateToUser() {Router.navigateTo(ViewName.USER);}

    public void navigateToPlayer() {Router.navigateTo(ViewName.PLAYER);}

    public void navigateToTeam() {Router.navigateTo(ViewName.TEAM);}
  
    public void navigateToMatch() {Router.navigateTo(ViewName.MATCH);}

    public void navigateToReferee() {Router.navigateTo(ViewName.REFEREE);}

}
