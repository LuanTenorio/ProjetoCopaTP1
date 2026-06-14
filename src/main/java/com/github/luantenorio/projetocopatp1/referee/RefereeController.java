package com.github.luantenorio.projetocopatp1.referee;

import com.github.luantenorio.projetocopatp1.util.Permission;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.Table;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class RefereeController extends Table<RefereeEntity>  {

    @FXML
    public TextField filterName;
    @FXML
    public TextField filterNationality;
    @FXML
    public TextField filterPerformanceTime;
    @FXML
    private Button btnCadastrar;

    private String nameFormated, nationalityFormated, performanceTimeFormated;

    private RefereeEntity activedFilters = new RefereeEntity("", "", 0, "");

    RefereeService refereeService = new RefereeService();

    public RefereeController(){
        super(3);
    }

    @FXML
    public void initialize() {
        this.objects = this.refereeService.findAll();
        this.renderTable();
        this.formatPerformanceTimeField();
        Permission.restrictToManagement(btnCadastrar);
    }

    protected boolean filterCondition(RefereeEntity object) {
        if(!this.nameFormated.isEmpty() && !object.getName().trim().toLowerCase().startsWith(this.nameFormated.toLowerCase()))
            return false;

        if(!this.nationalityFormated.isEmpty() && !object.getNationality().trim().toLowerCase().startsWith(this.nationalityFormated.toLowerCase()))
            return false;

        if(!this.performanceTimeFormated.equals("0") && !String.format("%d", object.getPerformanceTime()).startsWith(this.performanceTimeFormated))
            return false;

        return true;
    }

    protected boolean isEmptyFilters() {
        this.nameFormated = this.filterName.getText().trim().toLowerCase();
        this.nationalityFormated = this.filterNationality.getText().trim();
        this.performanceTimeFormated = this.filterPerformanceTime.getText().trim().toLowerCase();

        return nameFormated.isEmpty() && nationalityFormated.isEmpty() && performanceTimeFormated.isEmpty();
    }

    protected Label[] getLabels(RefereeEntity object) {
        return new Label[]{new Label(object.getName()), new Label(object.getNationality()), new Label(String.format("%d anos", object.getPerformanceTime()))};

    }

    protected void onRowClicked(RefereeEntity object) {
        Router.navigateTo(ViewName.UPDATE_REFEREE, object);
    }

    public void filterName() {
        this.activedFilters.setName(this.filterName.getText().trim());
        this.renderTable();
    }

    public void filterNationality() {
        this.activedFilters.setName(this.filterName.getText().trim());
        this.renderTable();
    }

    public void filterPerformanceTime() {
        this.activedFilters.setName(this.filterName.getText().trim());
        this.renderTable();
    }

    private void formatPerformanceTimeField(){
        TextFormatter<String> numberFormatter = new TextFormatter<>(change ->
                change.getText().matches("\\d*") ? change : null
        );

        this.filterPerformanceTime.setTextFormatter(numberFormatter);
    }

    public void navigateToCreateReferee(){
        Router.navigateTo(ViewName.UPDATE_REFEREE);
    }
}
