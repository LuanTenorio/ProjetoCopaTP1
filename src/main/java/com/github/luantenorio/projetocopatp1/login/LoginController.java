package com.github.luantenorio.projetocopatp1.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginBtn;

    @FXML
    protected void login() {
        boolean isValid = true;

        if(!isValid){
            //implementar autenticação
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/github/luantenorio/projetocopatp1/panel.fxml"));
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
