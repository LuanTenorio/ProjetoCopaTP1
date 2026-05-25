package com.github.luantenorio.projetocopatp1.team;

import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.Table;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TeamController extends Table<TeamEntity> {

    private final TeamService teamService = new TeamService();
    private final TeamEntity activedFilters = new TeamEntity("", "", "", "");

    private String nameFormated, groupFormated, coachFormated;

    @FXML
    private TextField filterName;
    @FXML
    private TextField filterGroup;
    @FXML
    private TextField filterCoach;

//    public VBox rowsContainer; atributo herdado de Table<T>
//    public Label infoPagination; atributo herdado de Table<T>

    public TeamController() {
        super(3);
    }

    public void initialize() {
        this.objetcs = this.teamService.findAll();
        this.renderTable();
    }

    public void navigateToCreateTeam() {
        Router.navigateTo(ViewName.CREATE_TEAM);
    }

    public void filterName() {
        this.activedFilters.setName(this.filterName.getText().trim());
        this.renderTable();
    }

    public void filterGroup() {
        this.activedFilters.setGroup(this.filterGroup.getText().trim());
        this.renderTable();
    }

    public void filterCoach() {
        this.activedFilters.setCoach(this.filterCoach.getText().trim());
        this.renderTable();
    }

    @Override
    protected boolean filterCondition(TeamEntity object) {
        if(!this.nameFormated.isEmpty() && !object.getName().trim().toLowerCase().startsWith(this.nameFormated))
            return false;

        if(!this.groupFormated.isEmpty() && !object.getGroup().trim().toLowerCase().startsWith(this.groupFormated))
            return false;

        if(!this.coachFormated.isEmpty() && !object.getCoach().trim().toLowerCase().startsWith(this.coachFormated))
            return false;

        return true;
    }

    @Override
    protected boolean isEmptyFilters() {
        this.nameFormated = this.filterName.getText().trim().toLowerCase();
        this.groupFormated = this.filterGroup.getText().trim().toLowerCase();
        this.coachFormated = this.filterCoach.getText().trim().toLowerCase();

        return nameFormated.isEmpty() && groupFormated.isEmpty() && coachFormated.isEmpty();
    }

    @Override
    protected Label[] getLabels(TeamEntity object) {
        return new Label[] {new Label(object.getName()), new Label(object.getGroup()), new Label(object.getCoach())};
    }

    @Override
    protected void onRowClicked(TeamEntity object) {
        Router.navigateTo(ViewName.UPDATE_TEAM, object);
    }
}
