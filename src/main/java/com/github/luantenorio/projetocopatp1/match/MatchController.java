package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.util.Permission;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.Table;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

public class MatchController extends Table<MatchEntity> {
    private MatchDAO matchDAO = new MatchDAO();

    @FXML
    private TextField filterTeam1;

    @FXML
    private TextField filterTeam2;

    @FXML
    private ComboBox<String> filterStage;

    @FXML
    private DatePicker filterDate;

    @FXML
    private Button btnCadastrar;

    public MatchController() {
        super(4);
    }

    @FXML
    public void initialize(){
        this.objetcs = this.matchDAO.findAll();
        ObservableList<String> stages = FXCollections.observableArrayList();
        for(MatchStage type : MatchStage.values()){
            stages.add(type.toString());
        }
        filterStage.setItems(stages);
        this.renderTable();
        Permission.restrictToManagement(btnCadastrar);
    }

    @Override
    protected boolean filterCondition(MatchEntity object) {

        if(!this.filterTeam1.getText().isEmpty() &&
                !object.getTeam1().getName().toLowerCase().contains(this.filterTeam1.getText().toLowerCase().trim()))
            return false;

        if(!this.filterTeam2.getText().isEmpty() &&
                !object.getTeam2().getName().toLowerCase().contains(this.filterTeam2.getText().toLowerCase().trim()))
            return false;

        if(this.filterStage.getSelectionModel().getSelectedItem() != null &&
                !this.filterStage.getSelectionModel().getSelectedItem().contains(object.getStage().toString()))
            return false;

        if(this.filterDate.getValue() != null) return object.getDate().toLocalDate().isEqual(this.filterDate.getValue());
        return true;
    }

    public void recreateTable(){
        this.renderTable();
    }

    @Override
    protected boolean isEmptyFilters() {
        return this.filterDate.getValue() == null &&
                this.filterTeam1.getText().isBlank() &&
                this.filterTeam2.getText().isBlank() &&
                this.filterStage.getSelectionModel().getSelectedItem() == null;
    }

    @Override
    protected Label[] getLabels(MatchEntity object) {
        return new Label[]{new Label(String.format("%s vs %s", object.getTeam1().getName(), object.getTeam2().getName())),
                new Label(object.getStage().toString()),
                new Label(object.getDate().toLocalDate().format(DateTimeFormatter.ISO_LOCAL_DATE)),
                new Label(String.format("%02d:%02d BRT",
                        object.getDate().getHour(), object.getDate().getMinute()))
        };
    }

    @Override
    protected void onRowClicked(MatchEntity object) {
        if (Permission.hasManagementAccess()) Router.navigateTo(ViewName.UPDATE_MATCH, object);
        /* TODO results */
    }

    @FXML
    private void navigateToCreateMatch(){
        Router.navigateTo(ViewName.CREATE_MATCH);
    }
}
