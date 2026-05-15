package com.github.luantenorio.projetocopatp1.stadium;

import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.Table;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;

public class StadiumController extends Table<StadiumEntity> {

    private StadiumDAO stadiumDAO = new StadiumDAO();
    private StadiumEntity activedFilters = new StadiumEntity("", "", 0);

    private String nameFormated, locationFormated, capacityFormated;

    @FXML
    private TextField filterName;

    @FXML
    private TextField filterLocation;

    @FXML
    private TextField filterCapacity;

    @FXML
    public VBox rowsContainer;

    @FXML
    public Label infoPagination;

    public StadiumController(){
        super(3);
    }

    @FXML
    public void initialize() {
        this.objetcs = this.stadiumDAO.findAll();
        this.renderTable();
        this.formatCapacityField();
    }

    protected Label[] getLabels(StadiumEntity stadium) {
        Label[] labels = {new Label(stadium.getName()), new Label(stadium.getLocation()), new Label(String.format("%d pessoas", stadium.getCapacity()))};
        return labels;
    }

    public void filterName(){
        this.activedFilters.setName(this.filterName.getText().trim());
        this.renderTable();
    }

    public void filterLocation(){
        this.activedFilters.setLocation(this.filterLocation.getText().trim());
        this.renderTable();
    }

    public void filterCapacity(){
        this.activedFilters.setCapacity(this.activedFilters.getCapacity());
        this.renderTable();
    }

    private void formatCapacityField(){
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
            change.getText().matches("\\d*") ? change : null
        );

        this.filterCapacity.setTextFormatter(numberFormatter);
    }

    protected boolean filterCondition(StadiumEntity stadium){
        if(!this.nameFormated.isEmpty() && !stadium.getName().trim().toLowerCase().startsWith(this.nameFormated))
            return false;

        if(!this.locationFormated.isEmpty() && !stadium.getLocation().trim().toLowerCase().startsWith(this.locationFormated))
            return false;

        if(!this.capacityFormated.equals("0") && !String.format("%d", stadium.getCapacity()).startsWith(this.capacityFormated))
            return false;

        return true;
    }

    protected boolean isEmptyFilters(){
        this.nameFormated = this.filterName.getText().trim().toLowerCase();
        this.locationFormated = this.filterLocation.getText().trim().toLowerCase();
        this.capacityFormated = this.filterCapacity.getText().trim();

        return nameFormated.isEmpty() && locationFormated.isEmpty() && capacityFormated.isEmpty();
    }

    public void navigateToCreateStadium(){
        Router.NavigateTo(ViewName.CREATE_STADIUM);
    }

}
