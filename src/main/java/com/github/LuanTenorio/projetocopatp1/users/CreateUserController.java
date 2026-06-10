package com.github.luantenorio.projetocopatp1.users;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateUserController {

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<String> txtRole;

    @FXML
    private ComboBox<String> txtStatus;

    @FXML
    private TextField txtCountry;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button buttonOperate;

    @FXML
    public void operate(MouseEvent event) {
        // lógica de cadastro
    }
}