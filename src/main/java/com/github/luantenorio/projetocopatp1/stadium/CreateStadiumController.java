package com.github.luantenorio.projetocopatp1.stadium;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class CreateStadiumController {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLocation;
    @FXML
    private TextField txtCapacity;

    @FXML
    public void initialize(){
        this.formatCapacityField();
    }

    public void register(){
        String name = txtName.getText();
        String location = txtLocation.getText();
        int capacity = Integer.parseInt(txtCapacity.getText());
    }

    private void formatCapacityField(){
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.txtCapacity.setTextFormatter(numberFormatter);
    }
}
