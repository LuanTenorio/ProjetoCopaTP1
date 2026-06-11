package com.github.luantenorio.projetocopatp1.player;

import com.github.luantenorio.projetocopatp1.util.Permission;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.Table;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Button btnCadastrar;

    public PlayerController() {
        super(5);
    }

    public void initialize() {
        this.objetcs = this.playerService.findAll();
        this.renderTable();
        this.formatNumberField();
        this.formatAgeField();
        Permission.restrictToManagement(btnCadastrar);
    }

    private void formatAgeField() {
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.filterAge.setTextFormatter(numberFormatter);
    }

    private void formatNumberField() {
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.filterNumber.setTextFormatter(numberFormatter);
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
        this.activedFilters.setNum(Integer.parseInt(this.filterNumber.getText() == "" ? "0" : this.filterNumber.getText()));
        this.renderTable();
    }

    public void filterAge() {
        this.activedFilters.setAge(Integer.parseInt(this.filterAge.getText() == "" ? "0" : this.filterAge.getText()));
        this.renderTable();
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
        if(!this.numberFormated.isEmpty() && !String.format("%d", object.getNum()).startsWith(this.numberFormated)) {
            return false;
        }
        if(!this.ageFormated.isEmpty() && !String.format("%d", object.getAge()).startsWith(this.ageFormated)) {
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
        Router.navigateTo(ViewName.UPDATE_PLAYER, object);
    }

    public void navigateToCreatePlayer() {
        Router.navigateTo(ViewName.CREATE_PLAYER);
    }
    }
