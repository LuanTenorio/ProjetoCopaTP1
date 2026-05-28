package com.github.luantenorio.projetocopatp1.player;

import com.github.luantenorio.projetocopatp1.util.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class PlayerController extends Table<PlayerEntity> {

    private final PlayerService playerService = new PlayerService();
    private final PlayerEntity activedFilters = new PlayerEntity("", "", 0, 0, null);

    private String nameFormated, positionFormated, numberFormated, ageFormated, statusFormated;

    @FXML
    private TextField filterName;
    @FXML
    private ComboBox<String> filterPosition;
    @FXML
    private TextField filterNumber;
    @FXML
    private ComboBox<String> filterStatus;
    @FXML
    private TextField filterAge;

    public PlayerController() {
        super(5);
    }

    public void initialize() {
        this.objetcs = this.playerService.findAll();
        this.renderTable();
    }

    public void filterName() {
        this.activedFilters.setName(this.filterName.getText().trim());
        this.renderTable();
    }

    public void filterPosition() {
        this.activedFilters.setPos(this.filterPosition.getValue());
        this.renderTable();
    }

    public void filterNumber() {
        //todo:
    }

    public void filterAge() {
        //todo:
    }

    public void filterStatus() {
        this.activedFilters.setStatus(playerService.stringToPlayerStatus(filterStatus.getValue()));
        this.renderTable();
    }

    @Override
    protected boolean filterCondition(PlayerEntity object) {
        if(!this.nameFormated.isEmpty() && !object.getName().trim().toLowerCase().startsWith(this.nameFormated)) {
            return false;
        }
        if(positionFormated != null && !object.getPos().equals(positionFormated)) {
            return false;
        }
        if(statusFormated != null && object.getStatus() != playerService.stringToPlayerStatus(statusFormated)) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean isEmptyFilters() {
        nameFormated = filterName.getText().trim().toLowerCase();
        positionFormated = filterPosition.getValue();
        numberFormated = filterNumber.getText().trim().toLowerCase();
        ageFormated = filterAge.getText().trim().toLowerCase();
        statusFormated = filterStatus.getValue();

        return nameFormated.isEmpty() && positionFormated==null && numberFormated.isEmpty() && ageFormated.isEmpty() && statusFormated==null;
    }

    @Override
    protected Label[] getLabels(PlayerEntity object) {
        return new Label[] { new Label(object.getName()), new Label(object.getPos()), new Label(String.format("%d", object.getNum())), new Label(String.format("%d", object.getAge())), new Label(object.getStatus().toString()) };
    }

    @Override
    protected void onRowClicked(PlayerEntity object) {

    }
}
