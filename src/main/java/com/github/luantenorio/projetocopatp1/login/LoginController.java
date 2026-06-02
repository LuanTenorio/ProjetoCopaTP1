package com.github.luantenorio.projetocopatp1.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button loginBtn;

    @FXML
    private ImageView topoImagem;

    @FXML
    private VBox rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        topoImagem.fitWidthProperty().bind(rootPane.widthProperty());
    }

    @FXML
    protected void login() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/luantenorio/projetocopatp1/view/panel.fxml"));
            Parent newRoot = loader.load();
            Stage curRoot = (Stage) loginBtn.getScene().getWindow();
            curRoot.getScene().setRoot(newRoot);
            curRoot.centerOnScreen();
        } catch (IOException e) {
            System.err.println("Erro ao carregar o painel: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
