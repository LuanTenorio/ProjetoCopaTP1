package com.github.luantenorio.projetocopatp1.stadium;

import com.github.luantenorio.projetocopatp1.util.Permission;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.Table;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.VBox;

public class StadiumController extends Table<StadiumEntity> {

    private final StadiumService stadiumService = new StadiumService();
    private final StadiumEntity activedFilters = new StadiumEntity("", "", 0);

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

    @FXML
    private Button btnCadastrar;

    public StadiumController(){
        super(3);
    }

    @FXML
    public void initialize() {
        this.objects = this.stadiumService.findAll();
        this.renderTable();
        this.formatCapacityField();
        Permission.restrictToManagement(btnCadastrar);
    }

    protected Label[] getLabels(StadiumEntity stadium) {
        return new Label[]{new Label(stadium.getName()), new Label(stadium.getLocation()), new Label(String.format("%d pessoas", stadium.getCapacity()))};
    }

    protected void onRowClicked(StadiumEntity object) {
        Router.navigateTo(ViewName.UPDATE_STADIUM, object);
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
        this.activedFilters.setCapacity(Integer.parseInt(this.filterCapacity.getText() == "" ? "0" : this.filterCapacity.getText()));
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

        if(!this.capacityFormated.isEmpty() && !String.format("%d", stadium.getCapacity()).startsWith(this.capacityFormated))
            return false;

        return true;
    }

    protected boolean isEmptyFilters(){
        this.nameFormated = this.filterName.getText().trim().toLowerCase();
        this.locationFormated = this.filterLocation.getText().trim().toLowerCase();
        this.capacityFormated = this.filterCapacity.getText().trim();

        System.out.println(this.capacityFormated);

        return nameFormated.isEmpty() && locationFormated.isEmpty() && capacityFormated.isEmpty();
    }

    public void navigateToCreateStadium(){
        Router.navigateTo(ViewName.CREATE_STADIUM);
    }

}
