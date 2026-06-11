package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.team.TeamDAO;
import com.github.luantenorio.projetocopatp1.team.TeamEntity;
import com.github.luantenorio.projetocopatp1.util.DataController;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.TimeTextField;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class FormMatchController implements DataController<MatchEntity> {

    MatchDAO dao = new MatchDAO();

    MatchEntity selectedMatch;

    ObservableList<String> teamOptions = FXCollections.observableArrayList();
    ObservableList<String> teamIDs = FXCollections.observableArrayList();
    ObservableList<String> stadiumOptions = FXCollections.observableArrayList();
    ObservableList<String> stadiumIDs = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> inputTeam1;
    @FXML
    private ComboBox<String> inputTeam2;
    @FXML
    private ComboBox<String> inputStage;
    @FXML
    private DatePicker inputDate;
    @FXML
    private TimeTextField inputTime;
    @FXML
    private ComboBox<String> inputStadium;
    @FXML
    private Button operateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button resultBtn;

    private boolean isEdit;

    @FXML
    public void initialize(){
        StadiumDAO stadiumDAO = new StadiumDAO();
        TeamDAO teamDAO = new TeamDAO();

        List<StadiumEntity> stadiums = stadiumDAO.findAll();
        List<TeamEntity> teams = teamDAO.findAll();

        // coloca em ordem alfabetica
        stadiums.sort((lhs, rhs) ->
                String.CASE_INSENSITIVE_ORDER.compare(lhs.getName(), rhs.getName())
        );
        teams.sort((lhs, rhs) ->
                String.CASE_INSENSITIVE_ORDER.compare(lhs.getName(), rhs.getName())
        );

        for (StadiumEntity stadium : stadiums) {
            stadiumOptions.add(stadium.getName());
            stadiumIDs.add(stadium.getId());
        }
        inputStadium.setItems(stadiumOptions);

        for (TeamEntity team : teams) {
            teamOptions.add(team.getName());
            teamIDs.add(team.getId());
        }
        inputTeam1.setItems(teamOptions);
        inputTeam2.setItems(teamOptions);

        ObservableList<String> stages = FXCollections.observableArrayList();
        for(MatchStage type : MatchStage.values()){
            stages.add(type.toString());
        }
        inputStage.setItems(stages);

        this.deleteBtn.setVisible(false);

        this.isEdit = false;
    }

    public void warn(String erro){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Campos inválidos");
        alert.setContentText(erro);
        alert.showAndWait();
    }

    public void operate(){
        TeamDAO teamDao = new TeamDAO();
        StadiumDAO stadiumDAO = new StadiumDAO();

        int team1Idx = inputTeam1.getSelectionModel().getSelectedIndex();
        if (team1Idx < 0) {
            warn("Selecione a seleção 1!");
            return;
        }
        String team1id = teamIDs.get(team1Idx);

        int team2Idx = inputTeam2.getSelectionModel().getSelectedIndex();
        if (team2Idx < 0) {
            warn("Selecione a seleção 1!");
            return;
        }
        String team2id = teamIDs.get(team2Idx);
        if (team2id == null) {
            warn("Selecione a seleção 2!");
            return;
        }

        int stadiumIdx = inputStadium.getSelectionModel().getSelectedIndex();
        if (stadiumIdx < 0) {
            warn("Selecione um estádio!");
            return;
        }
        String stadiumId = stadiumIDs.get(stadiumIdx);

        if (!inputTime.isValid()) {
            warn("Horário inválido!");
            return;
        }

        if (inputDate.getValue() == null) {
            warn("Selecione uma data!");
            return;
        }
        LocalDateTime dateTime = inputDate.getValue().atTime(inputTime.getHour(), inputTime.getMinute());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.systemDefault());
        MatchStage selected = MatchStage.findByName(inputStage.getSelectionModel().getSelectedItem());
        if (selected == null) {
            warn("Selecione uma fase!");
            return;
        }

        if (!this.isEdit) {
            MatchEntity match = new MatchEntity(
                    team1id, team2id, zonedDateTime, stadiumId, selected
            );
            dao.create(match);
        }
        else {
            selectedMatch.setTeam1(teamDao.findById(team1id));
            selectedMatch.setTeam2(teamDao.findById(team2id));
            selectedMatch.setStage(selected);
            selectedMatch.setDate(zonedDateTime);
            selectedMatch.setStadium(stadiumDAO.findById(stadiumId));
            dao.update(selectedMatch);
        }
        Router.navigateTo(ViewName.MATCH);
    }

    @FXML
    public void delete(){
        dao.delete(this.selectedMatch.getId());
        Router.navigateTo(ViewName.MATCH);
    }

    @Override
    public void getData(MatchEntity data) {
        this.selectedMatch = data;
        this.isEdit = true;
        this.setMatch();
        this.operateBtn.setText("ATUALIZAR");
        this.resultBtn.setText("Editar Resultado");
        this.deleteBtn.setVisible(true);
    }

    private void setMatch() {
        inputTeam1.getSelectionModel().select(selectedMatch.getTeam1().getName());
        inputTeam2.getSelectionModel().select(selectedMatch.getTeam2().getName());
        inputStage.getSelectionModel().select(selectedMatch.getStage().toString());
        inputDate.setValue(selectedMatch.getDate().toLocalDate());
        inputTime.setText(String.format("%02d:%02d",
                selectedMatch.getDate().getHour(),
                selectedMatch.getDate().getMinute()));
        inputStadium.getSelectionModel().select(selectedMatch.getStadium().getName());
    }
}
