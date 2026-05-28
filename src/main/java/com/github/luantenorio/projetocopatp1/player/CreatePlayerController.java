package com.github.luantenorio.projetocopatp1.player;

import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.util.DataController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CreatePlayerController implements DataController<PlayerEntity> {

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

}
