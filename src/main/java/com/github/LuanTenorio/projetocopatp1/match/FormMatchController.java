package com.github.luantenorio.projetocopatp1.match;

import com.github.luantenorio.projetocopatp1.stadium.StadiumDAO;
import com.github.luantenorio.projetocopatp1.stadium.StadiumEntity;
import com.github.luantenorio.projetocopatp1.team.TeamDAO;
import com.github.luantenorio.projetocopatp1.team.TeamEntity;
import com.github.luantenorio.projetocopatp1.util.Router;
import com.github.luantenorio.projetocopatp1.util.TimeTextField;
import com.github.luantenorio.projetocopatp1.util.ViewName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class FormMatchController {

    MatchDAO dao = new MatchDAO();

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

    }

    public void warn(){
        // TODO
    }

    public void register(){
        String team1id = teamIDs.get(inputTeam1.getSelectionModel().getSelectedIndex());
        String team2id = teamIDs.get(inputTeam2.getSelectionModel().getSelectedIndex());
        String stadiumId = stadiumIDs.get(inputStadium.getSelectionModel().getSelectedIndex());
        if (!inputTime.isValid()) {
            warn();
            return;
        }
        LocalDateTime dateTime = inputDate.getValue().atTime(inputTime.getHour(), inputTime.getMinute());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.systemDefault());
        MatchStage selected = MatchStage.findByName(inputStage.getSelectionModel().getSelectedItem());

        MatchEntity match = new MatchEntity(
            team1id, team2id, zonedDateTime, stadiumId, selected
        );
        dao.create(match);
        Router.navigateTo(ViewName.MATCH);
    }

    public void back() {

    }
}
