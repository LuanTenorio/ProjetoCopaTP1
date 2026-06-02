package com.github.luantenorio.projetocopatp1.player;

import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class CreatePlayerController implements DataController<PlayerEntity> {

    private PlayerService playerService = new PlayerService();

    private PlayerEntity playerSelected;

    private boolean isEdit = false;

    @FXML
    private TextField txtName;
    @FXML
    private ComboBox<String> txtPosition;
    @FXML
    private ComboBox<String> txtStatus;
    @FXML
    private TextField txtNumber;
    @FXML
    private TextField txtAge;
    @FXML
    private Button buttonOperate;
    @FXML
    private Button buttonDelete;

    public void initialize(){
        this.setVisibleDeleteButton(false);
        formatNameField();
        formatAgeField();
        formatNumberField();
    }

    private void formatNameField() {
        TextFormatter<String> nameFormatter = new TextFormatter<>(change ->
                change.getText().matches("[\\p{L}\\s]*") ? change : null
        );

        this.txtName.setTextFormatter(nameFormatter);
    }

    private void formatAgeField() {
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.txtAge.setTextFormatter(numberFormatter);
    }

    private void formatNumberField() {
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.txtNumber.setTextFormatter(numberFormatter);
    }

    @Override
    public void getData(PlayerEntity data) {
        this.playerSelected = data;
        this.isEdit = true;
        this.setPlayer();
        this.buttonOperate.setText("Atualizar");
        this.setVisibleDeleteButton(true);
    }

    private void setVisibleDeleteButton(boolean value) {
        this.buttonDelete.setVisible(value);
        this.buttonDelete.setManaged(value);
    }

    private void setPlayer() {
        txtName.setText(playerSelected.getName());
        txtPosition.setValue(playerSelected.getPos());
        txtStatus.setValue(playerSelected.getStatus().toString());
        txtNumber.setText(String.format("%d", playerSelected.getNum()));
        txtAge.setText(String.format("%d", playerSelected.getAge()));
    }

    public void operate(MouseEvent mouseEvent) {
        if(!this.isInputValid())
            return;

        if(this.isEdit)
            this.update();
        else
            this.register();
        
        backToPlayers();
    }

    private void register() {
        playerService.createPlayer(getCurrentEntity());
    }

    private void update() {
        playerService.updatePlayer(getCurrentEntity());
    }

    public void delete() {
        playerService.deletePlayer(playerSelected.getId());
        backToPlayers();
    }

    private void backToPlayers() {
        Router.navigateTo(ViewName.PLAYER);
    }

    private PlayerEntity getCurrentEntity() {
        String name = txtName.getText();
        String pos = txtPosition.getValue();
        int num = Integer.parseInt(txtNumber.getText());
        int age = Integer.parseInt(txtAge.getText());
        PlayerStatus status = playerService.stringToPlayerStatus(txtStatus.getValue());

        if(isEdit) {
            return new PlayerEntity(playerSelected.getId(), name, pos, num, age, status);
        }

        return new PlayerEntity(name, pos, num, age, status);
    }

    private boolean isInputValid() {
        String error = "";

        if (txtName.getText() == null || txtName.getText().trim().isEmpty())
            error += "O campo 'Nome' é obrigatório.\n";

        if (txtPosition.getValue() == null)
            error += "O campo 'Posição' é obrigatório.\n";

        if (txtStatus.getValue() == null)
            error += "O campo 'Status' é obrigatório.\n";
        
        if (txtAge.getText() == null || txtAge.getText().trim().isEmpty())
            error += "O campo 'Idade' é obrigatório.\n";

        if (txtNumber.getText() == null || txtNumber.getText().trim().isEmpty())
            error += "O campo 'Número' é obrigatório.\n";

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
