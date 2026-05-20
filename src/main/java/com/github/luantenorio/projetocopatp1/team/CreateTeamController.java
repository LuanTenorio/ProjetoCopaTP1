package com.github.luantenorio.projetocopatp1.team;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CreateTeamController {

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<String> groupComboBox;

    @FXML
    private TextField txtCoach;

    @FXML
    private ListView<?> availablePlayersList;

    @FXML
    private ListView<?> selectedPlayersList;

    @FXML
    private Button addPlayerButton;

    @FXML
    private Button removePlayerButton;
}
