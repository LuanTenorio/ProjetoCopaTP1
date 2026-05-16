package com.github.luantenorio.projetocopatp1.stadium;

import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class CreateStadiumController implements DataController<StadiumEntity> {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLocation;
    @FXML
    private TextField txtCapacity;
    @FXML
    private Button buttonOperate;

    private final StadiumService stadiumService = new StadiumService();
    private StadiumEntity stadiumSelected;
    private boolean isEdit = false;

    @FXML
    public void initialize(){
        this.formatCapacityField();
    }

    public void operate(){
        if(this.isEdit)
            this.update();
        else
            this.register();

        this.backToStadiums();
    }

    private void register(){
        this.stadiumService.createStadium(this.getCurrentEntity());
    }

    private void update(){
        this.stadiumService.updateStadium(this.getCurrentEntity());
    }

    private StadiumEntity getCurrentEntity(){
        String name = txtName.getText();
        String location = txtLocation.getText();
        int capacity = Integer.parseInt(txtCapacity.getText());

        if(this.isEdit)
            return new StadiumEntity(this.stadiumSelected.getId(), name, location, capacity);

        return new StadiumEntity(name, location, capacity);
    }

    private void formatCapacityField(){
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.txtCapacity.setTextFormatter(numberFormatter);
    }

    private void backToStadiums(){
        Router.navigateTo(ViewName.STADIUM);
    }

    public void getData(StadiumEntity data) {
        this.stadiumSelected = data;
        this.isEdit = true;
        this.setStadium();
        this.buttonOperate.setText("Atualizar");
    }

    private void setStadium(){
        txtName.setText(stadiumSelected.getName());
        txtLocation.setText(stadiumSelected.getLocation());
        txtCapacity.setText(String.valueOf(stadiumSelected.getCapacity()));
    }
}
