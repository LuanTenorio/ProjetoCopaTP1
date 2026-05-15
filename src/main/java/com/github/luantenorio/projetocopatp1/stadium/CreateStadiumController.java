package com.github.luantenorio.projetocopatp1.stadium;

import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
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

    private final StadiumService stadiumService = new StadiumService();

    @FXML
    public void initialize(){
        this.formatCapacityField();
    }

    public void register(){
        String name = txtName.getText();
        String location = txtLocation.getText();
        int capacity = Integer.parseInt(txtCapacity.getText());

        StadiumEntity stadium = new StadiumEntity(name, location, capacity);

        this.stadiumService.createStadium(stadium);
        Router.NavigateTo(ViewName.STADIUM);
    }

    private void formatCapacityField(){
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.txtCapacity.setTextFormatter(numberFormatter);
    }
}
