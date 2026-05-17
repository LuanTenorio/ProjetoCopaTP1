package com.github.luantenorio.projetocopatp1.stadium;

import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class FormStadiumController implements DataController<StadiumEntity> {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLocation;
    @FXML
    private TextField txtCapacity;
    @FXML
    private Button buttonOperate;
    @FXML
    private Button buttonDelete;

    private final StadiumService stadiumService = new StadiumService();
    private StadiumEntity stadiumSelected;
    private boolean isEdit = false;

    @FXML
    public void initialize(){
        this.formatCapacityField();
        this.setVisibleDeleteButton(false);
    }

    public void operate(){
        if(!this.isInputValid())
            return;

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
        this.setVisibleDeleteButton(true);
    }

    private void setStadium(){
        txtName.setText(stadiumSelected.getName());
        txtLocation.setText(stadiumSelected.getLocation());
        txtCapacity.setText(String.valueOf(stadiumSelected.getCapacity()));
    }

    public void delete(){
        this.stadiumService.deleteStadium(this.stadiumSelected.getId());
        this.backToStadiums();
    }

    private void setVisibleDeleteButton(boolean value) {
        this.buttonDelete.setVisible(value);
        this.buttonDelete.setManaged(value);
    }

    private boolean isInputValid() {
        String error = "";

        if (txtName.getText() == null || txtName.getText().trim().isEmpty())
            error += "O campo 'Nome' é obrigatório.\n";

        if (txtLocation.getText() == null || txtLocation.getText().trim().isEmpty())
            error += "O campo 'Localização' é obrigatório.\n";

        if (txtCapacity.getText() == null || txtCapacity.getText().trim().isEmpty())
            error += "O campo 'Capacidade' é obrigatório.\n";

        if (error.isEmpty())
            return true;

        this.showInvalidMessage(error);
        return false;
    }

    private void showInvalidMessage(String error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Campos inválidos");
        alert.setContentText(error);
        alert.showAndWait();
    }
}
